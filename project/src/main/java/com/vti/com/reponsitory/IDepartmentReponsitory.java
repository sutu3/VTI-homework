package com.vti.com.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.com.Entity.Department;

public interface IDepartmentReponsitory extends JpaRepository<Department, Integer> {
	
}
