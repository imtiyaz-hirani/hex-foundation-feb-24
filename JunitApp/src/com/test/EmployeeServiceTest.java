package com.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.exception.ResourceNotFoundException;
import com.model.Employee;
import com.service.EmployeeService;


public class EmployeeServiceTest {

	EmployeeService employeeService;
	
	@Before
	public void inlitiazeEmployeeServiceObj() {
		employeeService = new EmployeeService();
	}
	
	@Test
	public void getEmployeeByIdTest() {
		/* Use Case 1: Valid ID */
		Employee e1 = new Employee(1,"harry",88000,"IT");
		Employee e2 = new Employee(2,"ronald",75000,"ADMIN");
		Employee e3 = new Employee(3,"hermione",92000,"ADMIN");
		Employee e4 = new Employee(4,"draco",87000,"IT");
		
		List<Employee> list = new ArrayList<>();
		list.add(e1);list.add(e2);list.add(e3);list.add(e4);
		int id = 3; 
		Employee exceptedOutput = new Employee(3,"hermione",92000,"ADMIN");
		
		try {
			Assert.assertEquals(exceptedOutput, employeeService.getEmployeeById(list, id));
		} catch (ResourceNotFoundException e) {}
		
		/* Use Case 2: Invalid ID*/
		id = 5; 
		
		try {
			Assert.assertEquals(exceptedOutput, employeeService.getEmployeeById(list, id));
		} catch (ResourceNotFoundException e) {
			Assert.assertEquals("Invalid ID Given".toLowerCase(), e.getMessage().toLowerCase());
		}		
	}
	
	@After
	public void destroyEmployeeServiceObj() {
		employeeService = null;
	}
}
