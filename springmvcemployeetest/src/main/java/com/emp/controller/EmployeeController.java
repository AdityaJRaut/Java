package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@ModelAttribute
	public void com(Model model) {
		model.addAttribute("name", "Aditya");
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("name", "Aditya");
		return "home";
	}

	@RequestMapping("/list-emp")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.listEmployee());
		return "list-employees";
	}

	@RequestMapping("/add-emp")
	public String addEmp() {
		return "add-emp";
	}

	@PostMapping("/save-emp")
	public String getEmp(@ModelAttribute Employee employee) {
		System.out.println(employee);
		return "emp-details";
	}

}
