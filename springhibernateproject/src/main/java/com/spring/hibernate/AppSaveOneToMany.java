package com.spring.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Department;
import com.spring.hibernate.entity.Employee;

public class AppSaveOneToMany {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee employee1=Employee.builder()
				.name("Alice")
				.salary(8000)
				.build();
		Employee employee2=Employee.builder()
				.name("Ben")
				.salary(9000)
				.build();
		
		Employee employee3=Employee.builder()
				.name("Chris")
				.salary(800)
				.build();

		Employee employee4=Employee.builder()
				.name("David")
				.salary(900)
				.build();

		
		List<Employee> hrEmployees=new ArrayList<Employee>();
		hrEmployees.add(employee1);
		hrEmployees.add(employee2);
		
		List<Employee> itEmployees=new ArrayList<Employee>();
		itEmployees.add(employee3);
		itEmployees.add(employee4);		
		
		Department department1=Department.builder()
				.dname("IT")
				.city("Pune")
				.employees(itEmployees)
				.build();
		
		Department department2=Department.builder()
				.dname("HR")
				.city("Delhi")
				.employees(hrEmployees)
				.build();
		
		session.save(department1);
		session.save(department2);		
		
		tx.commit();
		Transaction transaction=session.beginTransaction();
		Department department=session.get(Department.class, 2);
		session.delete(department);
		transaction.commit();
		session.close();
		factory.close();
	}
}
