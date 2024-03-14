package com.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.dao.EmployeeDaoImpl;
import com.exception.SqlOperationFailedException;
import com.model.Employee;

public class EmployeeService {
	EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	public List<Employee> fetchAllEmployees() {
		List<Employee> list = employeeDao.fetchEmployees();
		return list;
	}

	public void insertEmployee(Employee emp) throws SqlOperationFailedException,SQLException{
		employeeDao.insertEmployee(emp);
	}

	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		
	}

	public void updateEmployee(int eid, String ename, double esalary) {
		employeeDao.updateEmployee(eid,ename,esalary);
		
	}

	public List<Employee> orderEmployeeRecords(List<Employee> list, String order) {
		 A a=new A();
		 B b=new B(); 
		 if(order.equalsIgnoreCase("a")) 
			 Collections.sort(list,a);
		 else 
			 Collections.sort(list,b);
		return list;
	}
}
class A implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		 if(e1.getSalary() > e2.getSalary())
			 return 1; 
		 if(e1.getSalary() < e2.getSalary())
			 return -1; 	 
		return 0;
	}
}
class B implements Comparator<Employee>{ //DESC [3,1] [1,3] [3,1]

	@Override
	public int compare(Employee e1, Employee e2) {
		 if(e1.getSalary() > e2.getSalary())
			 return -1; 
		 if(e1.getSalary() < e2.getSalary())
			 return 1; 
		 
		return 0;
	}
	
}



