package com.vti.com.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.com.Entity.Department;
import com.vti.com.Entity.Employee;
import com.vti.com.Form.EmployeeFrom;
import com.vti.com.Form.UpdateEmployeeFrom;
import com.vti.com.reponsitory.IEmployeereponsitory;

@Service
public class EmployeeServe implements IEmployeeServe {

	@Autowired
	private IEmployeereponsitory repository;
	
	@Autowired
	private IDepartmentService repository1;
	@Override
	public List<Employee> GetAll() {
		// TODO Auto-generated method stub
		System.out.println(repository.findAll());
		return repository.findAll();
	}
	@Override
	public Employee getemployeebyID(int id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public void createemployee(EmployeeFrom eFrom) {
		// TODO Auto-generated method stub
		
		 TypeMap<EmployeeFrom, Employee>
		  typtMap=modelMapper.getTypeMap(EmployeeFrom.class, Employee.class);
		  if(typtMap==null) { System.out.println(typtMap); modelMapper.addMappings(new
		 PropertyMap<EmployeeFrom, Employee>() {
		 
		 @Override protected void configure() { skip(destination.getId()); } }); }
		 
		System.out.println(modelMapper.map(eFrom,Employee.class));
		Employee employee=modelMapper.map(eFrom,Employee.class);
		employee.setDepartment(repository1.getdepartmentbyID(eFrom.getDepartmentid()));
		
		repository.save(employee);
		
	}
	@Override
	public void updataemployee(UpdateEmployeeFrom employee) {
		// TODO Auto-generated method stub
		Employee employee2=modelMapper.map(employee, Employee.class);
		employee2.setDepartment(repository1.getdepartmentbyID(employee.getDepartmentid()));
		repository.save(employee2);
	}
	@Override
	public void deleteemployee(Employee employee) {
		// TODO Auto-generated method stub
		repository.delete(employee);
		
	}
	
	
}
