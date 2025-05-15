package com.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.Repository.EmployeeRepository;
import com.ems.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	/*
	 * public List<Employee> listEmployee() { Employee e1=new Employee(1, "Aditya",
	 * "IT", "Male", "1994/01/28"); Employee e2=new Employee(2, "Bhushan", "IT",
	 * "Male", "1999/01/27"); Employee e3=new Employee(3, "Chris", "Finance",
	 * "Male", "1993/08/28"); Employee e4=new Employee(4, "David", "HR", "Male",
	 * "1987/09/21"); Employee e5=new Employee(5, "Elika", "IT", "Female",
	 * "2000/10/17"); List<Employee> employees=new ArrayList<Employee>();
	 * employees.add(e1); employees.add(e2); employees.add(e3); employees.add(e4);
	 * employees.add(e5); return employees;
	 * 
	 * }
	 */
	public int saveEmployee(Employee employee)
	{
		return this.employeeRepository.saveEmployee(employee);
		 
	}
	
	
}
