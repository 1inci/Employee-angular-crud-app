package com.employeeangularcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeangularcrud.model.Employee;
import com.employeeangularcrud.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	//@JsonIgnoreProperties(value = {"employee", "hibernateLazyInitializer"})
	EmployeeRepository employeeRepository;
	
	//Get all employees
	//http://localhost:8080/api/v1/employees
	//select * from TableName
	@GetMapping("/employees")
	public List<Employee>getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	//insert a employee
	//http://localhost:8080/api/v1/employees
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee getEmployee = employeeRepository.save(employee);
		return getEmployee;
	}
	
	 //Get a employee by id
	 //http://localhost:8080/api/v1/employees/{id}
	 //select * from TableName where id = 3 (e.g)
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
			Employee getEmployeeById = employeeRepository.findById(id).get();
			return ResponseEntity.ok().body(getEmployeeById);
		}
		
		
		//Update a employee by id
		//http://localhost:8080/api/v1/employees/{id}
		@PutMapping("/employees/{id}")
			public ResponseEntity<Employee> UpdateEmployeeById(@PathVariable Long id,
					@RequestBody Employee employee) {
				Employee emp = employeeRepository.findById(id).get();
				emp.setFirstName(employee.getFirstName());
				emp.setLastName(employee.getLastName());
				emp.setEmail(employee.getEmail());
				emp.setPhone(employee.getPhone());
				emp.setUserName(employee.getUserName());
				emp.setCountry(employee.getCountry());
				emp.setAddress(employee.getAddress());
				emp.setCratedTimestamp(emp.getCratedTimestamp());
				
				Employee updatedEmployee = employeeRepository.save(emp);
				
				return ResponseEntity.ok().body(updatedEmployee);
			}
		
		 //Delete a employee by id
		 //http://localhost:8080/api/v1/employees/{id}
		 @DeleteMapping("/employees/{id}")
			public String deleteEmployeeById(@PathVariable Long id) {
				Employee getEmployeeById = employeeRepository.findById(id).get();
				employeeRepository.delete(getEmployeeById);
				return "A record successfully deleted.";
			}
			
}
