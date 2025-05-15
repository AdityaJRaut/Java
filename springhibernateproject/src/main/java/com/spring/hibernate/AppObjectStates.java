package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Employee;

public class AppObjectStates {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory=cfg.buildSessionFactory();    	
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction(); //DMl queries

    	Employee emp=new Employee();
    	emp.setId(6);
    	emp.setName("Nilesh");
    	emp.setSalary(25000);			//transient
    	System.out.println(emp);
    	System.out.println("the object in transient state because it is not yet stored in database");
    	
    	session1.save(emp);				    	
    	tx.commit();				//Persistent
    	System.out.println("object saved using session.save(object) and commited");
    	System.out.println(emp);
    	System.out.println("now the object is in persistent state");
    	
    	System.out.println("Not query database because the same object is in session cache");
    	Employee emp1=session1.get(Employee.class, 6);//Not query the DB
    	System.out.println(emp1);
    	
    	System.out.println("session cleared");
    	session1.clear();				//Detached
    	System.out.println("emp 6 is in detached state");

    	System.out.println("as session clear the hibernate will query database for same object");
    	Employee emp2=session1.get(Employee.class, 6);//query the DB
    	System.out.println(emp2);
    	
    	
    	Transaction tx2=session1.beginTransaction();
    	System.out.println("same object deleted using session.delete(object)");
    	session1.delete(emp2);		//Removed
    	tx2.commit();
    	System.out.println("Now the object is in removed state");
    	
    	session1.close();
    	factory.close();

	}
}
