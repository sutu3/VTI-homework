package com.vti.com.Entity;

import java.io.Serializable;
import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@Entity
@Table(name = "`department`")
public class Department implements Serializable {

	private static final long serialVersionUID=1L;
	
	public Department() {
		super();
	}
	public Department(int departmentid, String name, List<Employee> employee) {
		super();
		this.departmentid = departmentid;
		this.name = name;
		this.employee = employee;
	}
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
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentid;
	@Column(name = "Name",length = 100,nullable = false,unique = true)
	@NonNull
	private String name;
	@OneToMany(mappedBy = "department")
	private List<Employee> employee;
	
}
