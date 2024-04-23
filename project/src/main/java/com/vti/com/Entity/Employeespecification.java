package com.vti.com.Entity;

import org.springframework.data.jpa.domain.Specification;

import io.micrometer.common.util.StringUtils;

public class Employeespecification {

	@SuppressWarnings("deprecation")
	public static Specification<Employee> buildWhere(String search){
		if(StringUtils.isEmpty(search))
		{
			return null;
		}
		search=search.trim();
		Customspecification name=new Customspecification("name",search);
		return name;
	}
}
