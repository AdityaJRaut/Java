package com.springcore.lifecycle.programming;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/programming/config.xml");
		context.registerShutdownHook();
		Student student = context.getBean("student", Student.class);
		System.out.println(student);		
	}

}
