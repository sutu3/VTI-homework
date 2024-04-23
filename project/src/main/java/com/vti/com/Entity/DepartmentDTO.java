package com.vti.com.Entity;

import java.util.List;

import io.micrometer.common.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO {
	@NonNull
	private int departmentid;
	@NonNull
	private String name;
	@NonNull
	private List<EmployyDTO> employee;
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<EmployyDTO> getEmployee() {
		return employee;
	}
	public void setEmployee(List<EmployyDTO> employee) {
		this.employee = employee;
	}
	public DepartmentDTO(int departmentid, String name, List<EmployyDTO> employee) {
		super();
		this.departmentid = departmentid;
		this.name = name;
		this.employee = employee;
	}
	public DepartmentDTO() {
		super();
	}
	
	
	
}
