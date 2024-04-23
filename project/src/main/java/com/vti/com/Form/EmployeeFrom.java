package com.vti.com.Form;

import org.modelmapper.internal.bytebuddy.asm.Advice.This;

import com.vti.com.Entity.Employee;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeFrom {

	public EmployeeFrom() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public EmployeeFrom(String name, int departmentid) {
		super();
		this.name = name;
		this.departmentid = departmentid;
	}

	private String name;

	private int departmentid;

	
}
