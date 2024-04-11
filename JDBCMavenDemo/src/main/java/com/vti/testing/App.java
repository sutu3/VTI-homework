package com.vti.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.CallableStatement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
    {
        System.out.println( "Hello World!" );
        Properties properties=new Properties();
        
        properties.load(new FileInputStream("src/main/resoure/database.properties"));
        System.out.println(properties);
        String urlString =properties.getProperty("url");
        String userString =properties.getProperty("user");
        String pasString=properties.getProperty("pass");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=DriverManager.getConnection(urlString,userString,pasString);
        System.out.println("connect success");
        String sqlString="{CALL sp_update_group(?,?)}";
        CallableStatement callableStatement=connection.prepareCall(sqlString);
        //CallableStatement dùng để chạy procedure trong my sql có sãn
        short groupid=1;
        String nameString=".NET Senior1";
        
        callableStatement.setShort(2 ,groupid);
        callableStatement.setString(1, nameString);
        
        int amount=callableStatement.executeUpdate();
        System.out.println("Effected Record Amound: "+amount);
        connection.close();
    }
}
