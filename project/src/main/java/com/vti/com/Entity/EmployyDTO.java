package com.vti.com.Entity;

import io.micrometer.common.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class EmployyDTO {

	private String name;
	private String departmentName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public EmployyDTO(String name, String departmentName) {
		super();
		this.name = name;
		this.departmentName = departmentName;
	}
	public EmployyDTO() {
		super();
	}
	
}
