package com.vti.com.Entity;

import org.springframework.data.jpa.domain.Specification;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Customspecification implements Specification<Employee> {

	public Customspecification(String field, Object value) {
		super();
		this.field = field;
		this.value = value;
	}
	@NonNull
	private String field;
	private Object value;
	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		if(field.equalsIgnoreCase("name"))
		{
			return criteriaBuilder.like(root.get("name"),"%"+value.toString()+"%");
			
		}
		
		return null;
	}
	
	
	
}
