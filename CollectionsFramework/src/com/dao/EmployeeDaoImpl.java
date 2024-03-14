package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.SqlOperationFailedException;
import com.model.Employee;

public class EmployeeDaoImpl {

	DBConnector db = new DBConnector();
	Connection conn; 
	public List<Employee> fetchEmployees() {
		/* Call dbConnect() */
		conn = db.dbConnect();
		List<Employee> list = new ArrayList<>(); //container created 
		/* Fetch data from DB */
		String sql="select * from employee";
		try {
			//Step 1: Prepare the statement to execute. 
			PreparedStatement pstmt= conn.prepareStatement(sql);
			//Step 2: execute the statement and catch it in ResultSet
			ResultSet rst= pstmt.executeQuery();
			//Step 3: Read the ResultSet and iterate over it to save objects in list. 
			while(rst.next()) {
				int id = rst.getInt("id");
				String name = rst.getString("name");
				double salary = rst.getDouble("salary");
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);
				list.add(e); //[id=1,id=2,id=3.....id=6]
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.dbClose();
		return list; 
	}
	
	public void insertEmployee(Employee emp) throws SqlOperationFailedException,SQLException{
		conn = db.dbConnect();
		String sql="insert into employee(name,city,salary,date_of_joining,department) values (?,?,?,?,?)";
			//prepare the statement 
			PreparedStatement pstmt= conn.prepareStatement(sql);
			//attach the values to ? 
			pstmt.setString(1,emp.getName());
			pstmt.setString(2,emp.getCity());
			pstmt.setDouble(3,emp.getSalary());
			pstmt.setString(4,emp.getDateOfJoining().toString());
			pstmt.setString(5,emp.getDepartment());
			//execute the query 
			int response = pstmt.executeUpdate(); //1: success  0: failure 
			if(response == 0) {
				throw new SqlOperationFailedException("Employee Insertion Problem");
			}
		  
		db.dbClose();
		
	}

	public void deleteEmployee(int id) {
		conn = db.dbConnect();
		String sql="delete from employee where id=?";
		//prepare the statement 
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			//attach the values to ? 
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		db.dbClose();
	}

	public void updateEmployee(int eid, String ename, double esalary) {
		conn = db.dbConnect();
		String sql="update employee SET name=?,salary=? where id=?";
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			//attach the values to ? 
			pstmt.setString(1,ename);
			pstmt.setDouble(2,esalary);
			pstmt.setInt(3,eid);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		
		db.dbClose();
	}
}














