package com.bridgelabz.EmployeePayrollApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Get all employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    // Add new employee
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    // Update employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setSalary(updatedEmployee.getSalary());

        return repository.save(existingEmployee);
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

        repository.delete(employee);
    }
}
