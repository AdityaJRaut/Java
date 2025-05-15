package com.em.controller;

import com.em.model.Employee;
import com.em.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeePageController {

    private final EmployeeService employeeService;

    public EmployeePageController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/test")
    public String test(Model model) {
        System.out.println("test");
        return "test";
    }

    // List all employees
    @RequestMapping("/employees")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";  // employees.jsp
    }

    // Show Add Employee Form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form"; // employee-form.jsp
    }

    // Show Edit Employee Form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form"; // employee-form.jsp
    }

    // Save Employee (Create or Update)
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees"; // After saving, redirect to list
    }

    // Delete Employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees"; // After deletion, redirect to list
    }
}
