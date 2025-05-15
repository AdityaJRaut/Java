package com.springcore.appconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class DriverApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.registerShutdownHook();
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
	}
}
