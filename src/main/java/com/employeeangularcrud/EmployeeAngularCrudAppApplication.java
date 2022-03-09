package com.employeeangularcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)

@SpringBootApplication
@ComponentScan(basePackages = "com.employeeangularcrud.controller")
public class EmployeeAngularCrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAngularCrudAppApplication.class, args);
	}

}
