package com.employeeangularcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeangularcrud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	
}
