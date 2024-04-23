package com.vti.com.Service;

import java.util.List;

import com.vti.com.Entity.Department;
import com.vti.com.Entity.Employee;
import com.vti.com.Form.DepartmentForm;
import com.vti.com.Form.UpdateDepartmentFrom;

public interface IDepartmentService {

	public List<Department> GetAll();
	public Department getdepartmentbyID(int id);
	public Department getdepartmentbyName(String name);
	public void createDepartment(DepartmentForm department);
	public void createDepartment(int id,String name);
	public void updataDepartment(UpdateDepartmentFrom department);
	public void updataDepartment(int id,String name);
	public void deleteDepartment(int id);
	public void deleteDepartment(Department department);
	public Department addDepartment(int id,Employee employee);
	public List<Department> xuat();
}
