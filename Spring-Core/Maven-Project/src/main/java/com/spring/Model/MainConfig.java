package com.spring.Model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
	@Bean
	public Student s1()
	{
		return new Student();
	}
	
	@Bean
	public Address a1()
	{
		return new Address();
	}
}
