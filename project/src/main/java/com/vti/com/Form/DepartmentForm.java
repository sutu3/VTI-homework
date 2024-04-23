package com.vti.com.Form;

import java.util.List;

import com.vti.com.Entity.Department;
import com.vti.com.Entity.Employee;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentForm {

	private int id;
	private String nameString;
	private List<Employee> employee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public DepartmentForm(int id, String nameString, List<Employee> employee) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.employee = employee;
	}
	public DepartmentForm() {
		super();
	}
	public static class Employee{
		private String nameString;

		public String getNameString() {
			return nameString;
		}

		public void setNameString(String nameString) {
			this.nameString = nameString;
		}

		public Employee(String nameString) {
			super();
			this.nameString = nameString;
		}

		public Employee() {
			super();
		}

		@Override
		public String toString() {
			return "Employee [nameString=" + nameString + "]";
		}
		
	}
	
	
	
}
