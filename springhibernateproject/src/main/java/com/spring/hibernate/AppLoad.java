package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Employee;

public class AppLoad {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session=factory.openSession();
    	Transaction tx=session.beginTransaction();
		
		Employee emp=new Employee(5, "Danish", 25000);
		
		session.save(emp);
		tx.commit();
    	
		//notes regarding load method
		//load method evrytime creates a dummy or proxy object when a object is requested by load method
		//the object created in session cache (in employee object scenario the object created will be like
		// Employee[id=3 name=null salary=0.0]
		//so when we try to access employee.getid it will display 3 without query to db
		//but when we try to access employee.getname it will query the database and fetch name and salary 
		//if the iobject is not in database it will throw object not found exception
		//lets say we try to load an object 25 which is not in db but the session cache will create a dummy object
		//in session cache and prevent exception but when we try to access other details except id it will throw
		//object not found exception.
    	Employee employee = session.load(Employee.class, 3);
    	System.out.println(employee.getId());
    	
    	session.close();
    	factory.close();

	}
}
