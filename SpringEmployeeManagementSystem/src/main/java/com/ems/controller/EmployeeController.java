package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {

	String username = "Aditya Raut";

	@Autowired
	EmployeeService employeeService;

	@ModelAttribute
	public void common(Model model) {
		System.out.println("inside common");
		model.addAttribute("username", username);
	}

	/*
	 * @RequestMapping("/") public String home() { return "index"; }
	 */

	@RequestMapping("/add-employee")
	public String addEmployee() {
		return "add-employee";
	}

	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {
		int id = (Integer) this.employeeService.saveEmployee(employee);
		model.addAttribute("msg", "Employee created with id " + id);
		return "save-employee";
	}

	@GetMapping("/")
	public String listEmployee(Model model) {
		// model.addAttribute("employees",employeeService.listEmployee());
		return "list-employees";
	}

}
