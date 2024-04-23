package com.vti.com.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.com.Entity.Employee;

public interface IEmployeereponsitory extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee> {

}
