package com.spring.project.crudapi.dao;

import java.util.List;
import com.spring.project.crudapi.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAllEmployee();
	public Employee findEmployee(int id);
	public Employee addEmployee(Employee employee);
	public String deleteEmployee(int id);
}
