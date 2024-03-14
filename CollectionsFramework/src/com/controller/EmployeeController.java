package com.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.SqlOperationFailedException;
import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeService();
		Scanner sc = new Scanner(System.in);
		while(true) 
		{
			System.out.println("****************Employee Info System****************");
			System.out.println("Press 1. to Insert the Employee record");
			System.out.println("Press 2. to Fetch all Employee records");
			System.out.println("Press 3. to Update single Employee record");
			System.out.println("Press 4. to Delete the Employee record");
			System.out.println("Press 0. To Exit");
			System.out.println("****************************************************");
			int input = sc.nextInt(); //user choice
			//what if user types 0 and wants to exit??? 
			if(input == 0) {
				System.out.println("Exiting... Thank you!!!!");
				break;
			}
			switch(input) {
				case 1: 
					//if 1 is pressed, we come here... 
					System.out.println("Enter name");
					sc.nextLine();
					String name =sc.nextLine();
					System.out.println("Enter city");
					String city = sc.next();
					System.out.println("Enter salary");
					double salary = sc.nextDouble();
					System.out.println("Enter department");
					String department = sc.next();
					
					//insert the record in DB
					Employee emp = new Employee(name,salary,city,LocalDate.now(),department,0);
				try {
					employeeService.insertEmployee(emp);
					System.out.println("Employee Inserted in DB");
				} catch (SqlOperationFailedException e1) {
					 System.out.println("Insertion Error: " +e1.getMessage());
				}
				catch(Exception e) {  System.out.println("Insertion Error: " +e.getMessage());     }
					
					break;
				case 2: 
					//if 2 is pressed, we come here...
					List<Employee> list = employeeService.fetchAllEmployees();
					
					//Iterate over the list 
					System.out.println("**************All Employees****************");
					System.out.println("\tID\t" + "Salary" + "        Name ");
					for(Employee e :list ) { //e=e1 e=e2 e=e3 e=e4
						System.out.println("\t"+e.getId() + "\t" + e.getSalary() + "        " + e.getName());
					}
					System.out.println("*******************************************");
					System.out.println("Do you want to order records by salary");
					System.out.println("Press A for ASC order");
					System.out.println("Press D for DESC order");
					String order = sc.next();
					if( !(order.equalsIgnoreCase("A") || order.equalsIgnoreCase("D")) ) {
						System.out.println("Invalid selection");
						break;
					}
					System.out.println("Now sort by order " + order);
					list = employeeService.orderEmployeeRecords(list,order);
					
					
					System.out.println("**************All Employees****************");
					System.out.println("\tID\t" + "Salary" + "        Name ");
					for(Employee e :list ) { //e=e1 e=e2 e=e3 e=e4
						System.out.println("\t"+e.getId() + "\t" + e.getSalary() + "        " + e.getName());
					}
					System.out.println("*******************************************");
					break;
				case 3: 
					System.out.println("Enter employee ID to update");
					int eid = sc.nextInt();
					System.out.println("Enter updated name");
					sc.nextLine();
					String ename = sc.nextLine();
					System.out.println("Enter updated salary");
					double esalary = sc.nextDouble();
					employeeService.updateEmployee(eid,ename,esalary);
					System.out.println("Record updated..");
					break;
				case 4: 
					//if 4 is pressed, we come here...
					System.out.println("Enter employee ID");
					int id = sc.nextInt();
					employeeService.deleteEmployee(id);
					System.out.println("Employee deleted");
					break;
				default: 
					//if anything other than 1-4 is pressed, we come here
					System.out.println("Invalid Input given..");
					break;
			}			
		}
		sc.close();
	}
}
