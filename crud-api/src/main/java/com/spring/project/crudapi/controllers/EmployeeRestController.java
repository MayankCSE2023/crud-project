package com.spring.project.crudapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.project.crudapi.entity.Employee;
import com.spring.project.crudapi.services.EmployeeServices;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	//initialise the dependency of service
	EmployeeServices employeeService;
	
	//inject the dependency
	@Autowired
	public EmployeeRestController(EmployeeServices employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/employees") // find all employee
	public List<Employee> getAllEmployee(){
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/employee/{id}")  // find a employee
	public Employee getEmployee(@PathVariable int id){
		Employee theEmployee=employeeService.findEmployee(id);
		
		if(theEmployee==null) {
			new RuntimeException("Employee id "+id+" not found!!");
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employee") // add new Employee
	public Employee addEmployee(@RequestBody Employee employee){
		employee.setId(0);
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/employee")  // update the Employee
	public Employee updateEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping("/employee/{id}")  //Delete a employee
	public String deleteEmployee(@PathVariable int id){
		return employeeService.deleteEmployee(id);
	}
	
}