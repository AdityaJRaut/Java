package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Employee;

public class AppGet {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session=factory.openSession();
    	Transaction tx=session.beginTransaction();
		
		Employee emp=new Employee(3, "Bhavesh", 2000);
		
		session.save(emp);
		tx.commit();
    	
		//notes regarding get method
		//get method first checks in session cache weather the object with provided id is
		//present in session cache (eg.session), if it is not there then only select query will
		//trigger and object is fetched from the database.
    	Employee employee = session.get(Employee.class, 3);
    	System.out.println(employee);
    	
    	session.close();
    	factory.close();

	}
}
