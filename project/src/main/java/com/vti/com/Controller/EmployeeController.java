package com.vti.com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.com.Entity.Employee;
import com.vti.com.Entity.EmployyDTO;
import com.vti.com.Form.EmployeeFrom;
import com.vti.com.Form.UpdateEmployeeFrom;
import com.vti.com.Service.IEmployeeServe;

@RestController
@RequestMapping(value = "api/v1/employee")
public class EmployeeController {

	@Autowired
	private ModelMapper modelMapper ;
	@Autowired
	
	private IEmployeeServe service;
	
	@GetMapping()
	public List<EmployyDTO> GetAll(){
		List<Employee> entities = service.GetAll();

		System.out.println(service.GetAll());
		// convert entities --> dtos
		List<EmployyDTO> dtos = modelMapper.map(entities, new TypeToken<List<EmployyDTO>>() {}.getType());
		
		System.out.println(dtos);
		return dtos;
	}
	@GetMapping(value = "/{id}")
	public EmployyDTO getEmployeebyID(@PathVariable(name ="id") int id) {
		 Employee employee=service.getemployeebyID(id);
		 EmployyDTO employyDTO=modelMapper.map(employee,EmployyDTO.class);
		 return employyDTO;
	}
	
	@PostMapping()
	public void createEmployee(@RequestBody EmployeeFrom from)
	{
		service.createemployee(from);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteEmployee(@PathVariable(name ="id") int id) {
		service.deleteemployee(service.getemployeebyID(id));
	}
	@PutMapping(value="/{id}")
	public void updateEmployee(@PathVariable(name="id") int id,@RequestBody UpdateEmployeeFrom from) {
		from.setEmployeeID(id);
		service.updataemployee(from);
	}
}
