package com.alpha.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.demo.model.Employee;
import com.alpha.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployee(long id) {
		
		
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Employee getId(long id) {
		Optional<Employee> optional=employeeRepository.findById(id);
		Employee employee =new Employee();
		employee=null;
		if(optional.isPresent())
		{
		employee=optional.get();
		}
		else {
			employee=null;
		}
		return employee;
		
	}

	
	
}
