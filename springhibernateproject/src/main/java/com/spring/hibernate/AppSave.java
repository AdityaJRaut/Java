package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Employee;

public class AppSave {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Employee emp=new Employee(1, "Aditya", 25000);
		
		Session session=factory.openSession();
    	Transaction tx=session.beginTransaction();
    	
    	session.save(emp);
    	tx.commit();
    	
    	session.close();
    	factory.close();

	}
}
