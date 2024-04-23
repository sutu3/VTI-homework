package com.vti.com.Form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateDepartmentFrom {

	private int departmentid;
	private String name;
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
	public UpdateDepartmentFrom(int departmentid, String name) {
		super();
		this.departmentid = departmentid;
		this.name = name;
	}
	@Override
	public String toString() {
		return "UpdateDepartmentFrom [departmentid=" + departmentid + ", name=" + name + "]";
	}
	public UpdateDepartmentFrom() {
		super();
	}
	
}
