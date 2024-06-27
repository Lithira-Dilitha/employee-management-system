package edu.ict.hris.service;

import edu.ict.hris.dto.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAll();
    void deleteEmployeeById(Long id);
    Employee updateEmployee(Employee employee);

    Employee findById(Long id);

    Employee findByFirstName(String name);
}
