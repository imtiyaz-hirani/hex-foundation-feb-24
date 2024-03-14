package com.dao;

import java.sql.*;

public class DBConnector {

	/* Step 1: Defined all DB variable */
	private String usernameDb="root";
	private String passwordDb="";
	private String urlDb="jdbc:mysql://localhost:3306/hexfeb2024";
	private String driverName="com.mysql.cj.jdbc.Driver";
	private Connection conn; 
	
	public Connection dbConnect() {
		/* Step 2: Load The driver */
		try {
			Class.forName(driverName);
			//System.out.println("Driver loaded successfully..");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver could not be loaded");
			e.printStackTrace();
		} 
		
		/* Step 3: Establish the connection */
		try {
			conn = DriverManager.getConnection(urlDb, usernameDb, passwordDb);
			//System.out.println("Connection established..");
		} catch (SQLException e) {
			System.out.println("Connection could not be established");
			e.printStackTrace();
		}
		
		return conn; 
	}
	
	public void dbClose() {
		try {
			conn.close();
			//System.out.println("Connection closed..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
