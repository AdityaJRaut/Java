package com.springcore.si;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/si/config.xml");
		Employee emp = context.getBean("employee", Employee.class);
		System.out.println(emp);
	}

}
