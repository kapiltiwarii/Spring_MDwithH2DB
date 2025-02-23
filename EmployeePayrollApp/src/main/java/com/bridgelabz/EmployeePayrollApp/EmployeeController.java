package com.bridgelabz.EmployeePayrollApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // Add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    // Update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return service.updateEmployee(id, updatedEmployee);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee with ID " + id + " deleted successfully.";
    }
}
