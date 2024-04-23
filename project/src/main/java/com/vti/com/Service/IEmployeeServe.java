package com.vti.com.Service;

import java.util.List;

import com.vti.com.Entity.Employee;
import com.vti.com.Form.EmployeeFrom;
import com.vti.com.Form.UpdateEmployeeFrom;

public interface IEmployeeServe {

	public List<Employee> GetAll();
	public Employee getemployeebyID(int id);
	public Employee getemployeebyName(String name);
	public void createemployee(EmployeeFrom eFrom);
	public void createemployee(int id,String name);
	public void updataemployee(UpdateEmployeeFrom employee);
	public void updataemployee(int id,String name);
	public void deleteemployee(int id);
	public void deleteemployee(Employee employee);
}
