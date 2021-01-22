package com.springboot.demo.service;

import com.springboot.demo.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(int id);
    void deleteEmployee(Employee employee);
    Page<Employee> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection);
}
