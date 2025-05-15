package com.emp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.model.Employee;
@Service
public class EmployeeService {

	public List<Employee> listEmployee()
	{
		Employee e1=new Employee(1, "emp1", 1);
		Employee e2=new Employee(2, "emp2", 2);
		Employee e3=new Employee(3, "emp3", 3);
		Employee e4=new Employee(4, "emp4", 4);
		Employee e5=new Employee(5, "emp5", 5);
		List<Employee> emp=new ArrayList<Employee>();
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		emp.add(e4);
		emp.add(e5);
		return emp;
	}
}
