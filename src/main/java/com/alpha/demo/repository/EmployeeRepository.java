package com.alpha.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
