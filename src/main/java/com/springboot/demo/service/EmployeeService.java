package com.springboot.demo.service;

import com.springboot.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(int id);
    void deleteEmployee(Employee employee);
}
