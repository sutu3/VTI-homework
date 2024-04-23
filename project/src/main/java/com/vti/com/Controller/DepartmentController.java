package com.vti.com.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.com.Entity.Department;
import com.vti.com.Entity.DepartmentDTO;
import com.vti.com.Entity.Employee;
import com.vti.com.Form.DepartmentForm;
import com.vti.com.Form.UpdateDepartmentFrom;
import com.vti.com.Service.IDepartmentService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "api/v1/department")
public class DepartmentController {

	@Autowired
	private ModelMapper modelMapper ;
	@Autowired
	private IDepartmentService service;
	
	@GetMapping() /*
					 * public void xuat() { System.out.println(service.GetAll()); }
					 * 
					 */
	  public List<DepartmentDTO> getData() { 
		
		List<Department> data =service.GetAll(); 
		
		List<DepartmentDTO> departmentDTO=modelMapper.map(data,new TypeToken<List<DepartmentDTO>>(){}.getType());
		return departmentDTO;
	  }
	 
	@GetMapping(value = "/{id}")
	public DepartmentDTO getDepartmentbyID(@PathVariable(name ="id") int id) {
		Department department= service.getdepartmentbyID(id);
		DepartmentDTO departmentDTO=modelMapper.map(department, DepartmentDTO.class);
		return departmentDTO;
	}
	 
	@PostMapping()
	public void createDepartment(@RequestBody DepartmentForm from)
	{
		service.createDepartment(from);
	}
	@PutMapping(value = "/{id}")
	public void UpdateDepartment(@PathVariable(name="id") int id,@RequestBody UpdateDepartmentFrom from) {
		from.setDepartmentid(id);
		service.updataDepartment(from);
	}
	@DeleteMapping(value="/{id}")
	public void DeleteDepartment(@PathVariable(name="id") int id) {
		service.deleteDepartment(service.getdepartmentbyID(id));
	}
}
