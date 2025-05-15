package com.em.service;

import com.em.model.Employee;
import com.em.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee)
    {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found with id "+id));

        emp.setId(id);
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setDepartment(employee.getDepartment());
        return employeeRepository.save(emp);
    }

    public Optional<Employee> getEmployeeById(Long id)
    {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public List<Employee> getHighPaidEmployees(double minSalary)
    {
        return employeeRepository.findAll().stream()
                .filter(emp->emp.getSalary()>=minSalary)
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesByDepartmentSorted(String department)
    {
        return employeeRepository.findAll().stream()
                .filter(emp->emp.getDepartment().equalsIgnoreCase(department))
                .sorted(Comparator.comparing(Employee::getName))
                        .collect(Collectors.toList());
    }

    public Optional<Employee> getEmployeeWithHighestSalary()
    {
        return employeeRepository.findAll().stream()
                .max(Comparator.comparing(Employee::getSalary));
    }

    public Map<String, List<Employee>> groupEmployeesByDepartment()
    {
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
