package com.vti.com.Form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateEmployeeFrom {
	private int EmployeeID;
	private String nameEmployee;
	private int Departmentid;
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public String getNameEmployee() {
		return nameEmployee;
	}
	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}
	public int getDepartmentid() {
		return Departmentid;
	}
	public void setDepartmentid(int departmentid) {
		Departmentid = departmentid;
	}
	public UpdateEmployeeFrom(int employeeID, String nameEmployee, int departmentid) {
		super();
		EmployeeID = employeeID;
		this.nameEmployee = nameEmployee;
		Departmentid = departmentid;
	}
	public UpdateEmployeeFrom() {
		super();
	}
	@Override
	public String toString() {
		return "UpdateEmployeeFrom [EmployeeID=" + EmployeeID + ", nameEmployee=" + nameEmployee + ", Departmentid="
				+ Departmentid + "]";
	}
	
}
