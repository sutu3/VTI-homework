package com.vti.com.Entity;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentCofiguration {

	@Bean
	public ModelMapper initModelMapper() {
		return new ModelMapper  ();
	} 
}
