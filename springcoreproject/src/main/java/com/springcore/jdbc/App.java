package com.springcore.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.jdbc.dao.CustomerDao;
import com.springcore.jdbc.entity.Customer;

public class App {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/jdbc/config.xml");
		// ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerDao dao = context.getBean("customerDaoImpl", CustomerDao.class);
		Customer customer = context.getBean("customer", Customer.class);
		int result = dao.insertCustomer(customer);
		System.out.println("Record inserted... " + result);
	}

}
