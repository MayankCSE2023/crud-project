package com.spring.project.crudapi.services;

import java.util.List;

import com.spring.project.crudapi.entity.Employee;

public interface EmployeeServices {
	
	public List<Employee> findAllEmployees();
	public Employee findEmployee(int id);
	public Employee addEmployee(Employee employee);
	public String deleteEmployee(int id);
}
