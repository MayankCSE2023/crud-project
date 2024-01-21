package com.spring.project.crudapi.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.project.crudapi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

//--------------------This is old fashioned -----------------------------------------------
//---------------------------Spring Data JPA(New Way for DAO)------------------------------------------------

//@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //initialise a entitymanager
	EntityManager entityManager;
	
	//inject entity manager through constructor
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	
	@Override
	public List<Employee> findAllEmployee() {
		
		//create a query
		TypedQuery<Employee> query= entityManager.createQuery("from Employee",Employee.class);// in query name in the pojo class is to ne mentioned not the name use in mysql Employee
				
		//execute the query
		List<Employee> allEmployee=query.getResultList();
				
		//return the result		
		return allEmployee;
	}


	@Override
	public Employee findEmployee(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		return employee;
	}


	@Override
	public Employee addEmployee(Employee employee) {
		Employee newEmployee=entityManager.merge(employee);
		return newEmployee;
	}


	@Override
	public String deleteEmployee(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		entityManager.remove(employee);
		return employee.toString()+" is successfully deleted from database";
	}

}
