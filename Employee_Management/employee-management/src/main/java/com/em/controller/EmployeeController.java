package com.em.controller;

import com.em.model.Employee;
import com.em.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails) {
        Employee updatedEmployee= employeeService.updateEmployee(id,employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/highsalary/{minsalary}")
    public List<Employee> getHighPaidEmployees(@PathVariable int minsalary) {
        return employeeService.getHighPaidEmployees(minsalary);
    }

    @GetMapping("/department/{dept}")
    public List<Employee> getEmployeesByDepartmentSorted(@PathVariable String dept) {
        return employeeService.getEmployeesByDepartmentSorted(dept);
    }

    @GetMapping("/highestpaid")
    public Optional<Employee> getEmployeeWithHighestSalary() {
        return employeeService.getEmployeeWithHighestSalary();
    }

    @GetMapping("/groupbydepartment")
    public Map<String,List<Employee>> getEmployeeWithGroupByDepartment() {
        return employeeService.groupEmployeesByDepartment();
    }
}
