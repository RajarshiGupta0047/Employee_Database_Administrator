package com.alpha.demo.service;

import java.util.List;
import java.util.Optional;

import com.alpha.demo.model.Employee;

public interface EmployeeService {
List<Employee> getAllEmployees();
void saveEmployee(Employee employee);
void deleteEmployee(long id);
Employee getId(long id);
}
