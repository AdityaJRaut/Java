package com.springcore.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean(name = "student")
	@Scope(value = "singleton")
	public Student studentConstructor() {
		Student student = new Student();
		student.setRno(1);
		student.setName("Aditya Raut");
		student.setMarks(99.99);
		return student;
	}
}
