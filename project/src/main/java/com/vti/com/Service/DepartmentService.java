package com.vti.com.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.com.Entity.Department;
import com.vti.com.Entity.Employee;
import com.vti.com.Form.DepartmentForm;
import com.vti.com.Form.EmployeeFrom;
import com.vti.com.Form.UpdateDepartmentFrom;
import com.vti.com.reponsitory.IDepartmentReponsitory;
import com.vti.com.reponsitory.IEmployeereponsitory;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentReponsitory reponsitory;
	@Autowired
	private IEmployeeServe reponsitory1;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<Department> GetAll() {
		// TODO Auto-generated method stub
		System.out.println(reponsitory.findAll());
		return reponsitory.findAll();
	}
	public List<Department> xuat(){
		List<Department> departments=new ArrayList<>();
		for (Department department : reponsitory.findAll()) {
			Department newDepartment= new Department();
			newDepartment.setDepartmentid(department.getDepartmentid());
			newDepartment.setName(department.getName());
			newDepartment.setEmployee(department.getEmployee());
			departments.add(newDepartment);
		    System.out.println("----");
		  }
		return departments;
	}
	@Override
	public Department getdepartmentbyID(int id) {
		// TODO Auto-generated method stub
		return reponsitory.findById(id).get();
	}
	

	@Override
	@Transactional
	public void createDepartment(DepartmentForm from) {
		// TODO Auto-generated method stub
		Department department= modelMapper.map(from,Department.class );
		System.out.println(department.getEmployee());
		Department department2=reponsitory.save(department);
		List<Employee> list=department.getEmployee();
		for(Employee em:list) {
			em.setDepartment(department2);
			System.out.println(em.getName());
			System.out.println(em.getDepartment().getDepartmentid());
			reponsitory1.createemployee(new EmployeeFrom(em.getName(), em.getDepartment().getDepartmentid()));
		}
		reponsitory.save(department);
	}


	@Override
	public Department addDepartment(int id, Employee employee) {
		// TODO Auto-generated method stub
		Department department=reponsitory.getById(id);
		employee.setDepartment(department);
		department.getEmployee().add(employee);
		reponsitory.save(department);
		return department;
	}

	@Override
	public void updataDepartment(UpdateDepartmentFrom department) {
		// TODO Auto-generated method stub
		Department department2=modelMapper.map(department, Department.class);
		reponsitory.save(department2);
		
	}


	@Override
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		for(Employee em:department.getEmployee())
		{
			em.setDepartment(null);
		}
		department.getEmployee().clear();
		reponsitory.delete(department);
		
	}

	
}
