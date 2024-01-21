package com.spring.project.crudapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.crudapi.dao.EmployeeRepository;
import com.spring.project.crudapi.entity.Employee;

//------------------------------------This class is obselete-------------------------------------
//------------------------------------Spring data JPA Repository-----------------------------------------

@Service
public class EmployeeServiceImpl implements EmployeeServices{

	//Initiate employeedao object
		EmployeeRepository employeeRepository;
		
		// inject employee doa dependencies though constructor
		@Autowired
		public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
			this.employeeRepository=employeeRepository;
		}
		
		@Override
		public List<Employee> findAllEmployees() {
			return employeeRepository.findAll();
		}
		
		
		@Override
		public Employee findEmployee(int id) {
			//In Java, Optional is a container class that may or may not contain a non-null value. 
			Optional<Employee> result=employeeRepository.findById(id);//Preventing Null Pointer Exceptions
			
			Employee theEmployee=null;
			
			if(result.isPresent()) {// if result is not null
				theEmployee=result.get();
			}else {
				throw new RuntimeException("No Employee Present with ID: "+ id); 
			}
			
			
			return theEmployee;
		}


		@Override
		//@Transactional  -- no need of tranasaction as spring data JPA already provides this functionality
		public Employee addEmployee(Employee employee) {
			return employeeRepository.save(employee);
		}


		@Override
		//@Transactional
		public String deleteEmployee(int id) {
		   employeeRepository.deleteById(id);
		   return "Employee ID : "+id+" is Deleted.";
		}
	
	
	
	
	
	
	
	//-----------------------Obselete---------------------------------------------
	
	
	
	
	
//	//Initiate employeedao object
//	EmployeeDAO employeeDAO;
//	
//	// inject employee doa dependencies though constructor
//	@Autowired
//	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
//		this.employeeDAO=employeeDAO;
//	}
//	
//	@Override
//	public List<Employee> findAllEmployees() {
//		return employeeDAO.findAllEmployee();
//	}
//	
//	
//	@Override
//	public Employee findEmployee(int id) {
//		return employeeDAO.findEmployee(id);
//	}
//
//
//	@Override
//	@Transactional
//	public Employee addEmployee(Employee employee) {
//		return employeeDAO.addEmployee(employee);
//	}
//
//
//	@Override
//	@Transactional
//	public String deleteEmployee(int id) {
//		return employeeDAO.deleteEmployee(id);
//	}


}
