package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class project {

	public static Connection getConnection() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Properties properties=new Properties();
        properties.load(new FileInputStream("JDBCMavenDemo/src/main/resoure/database.properties"));
		System.out.println(properties);
		String url=properties.getProperty("url");
		String user=properties.getProperty("user");
		String pass=properties.getProperty("pass");
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,user,pass);
		}
	private static void createUser(Connection connection) throws SQLException {
		String sqlString="insert into `user` (`username`,`email`,`password`,`firstName`,`lastName`,`gender`,`date_Of_Birth`,`address`,`phone`,`role`,`status`) value(?,?,?,?,?,?,?,?,?,?)";
		int status=0;
		PreparedStatement perPreparedStatement=connection.prepareStatement(sqlString);
		String username="xuanmaivti",email="hungnguyen@gmail.com",password="123456",firstname="Pham",lastName="quang Hung",gender="M",dateofBirth="1999-02-02",address="TPHCM",phone="1234567890",role="Employee";
		perPreparedStatement.setString(1, username);
		perPreparedStatement.setString(2, email);
		perPreparedStatement.setString(3, password);
		perPreparedStatement.setString(4, firstname);
		perPreparedStatement.setString(5, lastName);
		perPreparedStatement.setString(6, gender);
		perPreparedStatement.setString(7, dateofBirth);
		perPreparedStatement.setString(8, address);
		perPreparedStatement.setString(9, phone);
		perPreparedStatement.setString(10, role);
		perPreparedStatement.setInt(11, status);
		int amount=perPreparedStatement.executeUpdate();
		System.out.println("Effected Record Amoung: "+amount);
	}
	public static void createGroup(Connection connection) throws SQLException {
		String sqlString="Insert into `testingsystem.group`(`name`,`author_ID`) value (?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sqlString);
		String nameString=".Net senior1";
		short id=1;
		preparedStatement.setString(1, nameString);
		preparedStatement.setShort(2, id);
		int amount=preparedStatement.executeUpdate();
		System.out.println("Effected Record Amoung: "+amount);
	}
	public static void addUsertoGroup(Connection connection) throws SQLException {
		String sqlString="Insert into `user_group`(`group_id`,`user_id`) value (?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sqlString);
		short nameString=4;
		short id=17;
		preparedStatement.setShort(1, nameString);
		preparedStatement.setShort(2, id);
		int amount=preparedStatement.executeUpdate();
		System.out.println("Effected Record Amoung: "+amount);
	}
    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		/*
		 * String dburlString = "jdbc:mysql://localhost:3306/testingsystem"; String
		 * userString = "root"; String pasString = "";
		 * Class.forName("com.mysql.cj.jdbc.Driver"); String aString=""; short bString;
		 * Scanner in=new Scanner(System.in); try {
		 * 
		 * System.out.println("Nhap a: "); bString=in.nextShort(); delete(dburlString,
		 * userString, pasString,bString); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
    	Connection connection=getConnection();
    	try {
			createGroup(connection);
			createUser(connection);
			createGroup(connection);
			connection.commit();
			System.out.println("Transaction Comit!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			connection.rollback();
			System.out.println("Transaction Rollback!");
		}
    	connection.setAutoCommit(true);
    	connection.close();
    }
    public static void delete(String url, String user,String pass, Short b) throws SQLException
    {
    	Connection myConnection=DriverManager.getConnection(url,user,pass);
    	System.out.println("Connect Thành Công");
    	String sql="Delete from testingsystem.group where (`id`=?)";
    	PreparedStatement PreparedStatement =myConnection.prepareStatement(sql);
    	PreparedStatement.setShort(1, b);
    	int amount=PreparedStatement.executeUpdate();
    	System.out.println(amount);
    	System.out.println("Effected Record Amount: "+amount);
    }
    public static void update(String url, String user,String pass,String a, Short b) throws SQLException
    {
    	Connection myConnection=DriverManager.getConnection(url,user,pass);
    	System.out.println("Connect Thành Công");
    	String sql="Update testingsystem.group set `name`=? where `id`=? ;";
    	PreparedStatement PreparedStatement =myConnection.prepareStatement(sql);
    	PreparedStatement.setString(1, a);
    	PreparedStatement.setShort(2, b);
    	int amount=PreparedStatement.executeUpdate();
    	System.out.println("Effected Record Amount: "+amount);
    }
    public static void nhapnv(String url, String user,String pass,String a, Short b) throws SQLException
    {
    	Connection myConnection=DriverManager.getConnection(url,user,pass);
    	System.out.println("Connect Thành Công");
    	String sql="insert into testingsystem.group(`name`,author_ID) value(?,?)";
    	PreparedStatement PreparedStatement =myConnection.prepareStatement(sql);
    	PreparedStatement.setString(1, a);
    	PreparedStatement.setShort(2, b);
    	int amount=PreparedStatement.executeUpdate();
    	System.out.println("Effected Record Amount: "+amount);
    	
    }
    public static void nhap(String url, String user, String pass) throws SQLException {
        Connection myConn = DriverManager.getConnection(url, user, pass);
        System.out.println("connect thành công");
        Statement mysql = myConn.createStatement();
        String sql="insert into testing_exam(exam_id,testing_id) value(2,3)";
        int effectedRecordAmount=mysql.executeUpdate(sql);
        System.out.println("Effected Record Amount: "+effectedRecordAmount);
        myConn.close();
    }
    public static void xuat(String url, String user, String pass) throws SQLException {
        Connection myConn = DriverManager.getConnection(url, user, pass);
        System.out.println("connect thành công");
        Statement mysql = myConn.createStatement();
        ResultSet myRaResultSet = mysql.executeQuery("select exam_id, testing_id from testing_exam");
        while (myRaResultSet.next()) {
            System.out.println(myRaResultSet.getInt("exam_id"));
            System.out.println(myRaResultSet.getInt("testing_id"));
        }
    }
}