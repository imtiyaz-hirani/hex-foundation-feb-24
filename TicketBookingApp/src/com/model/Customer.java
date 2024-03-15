package com.model;

public class Customer {
	private int id; 
	private String customerName; 
	private String email;
	private String phoneNumber;
	
	public Customer() {  }

	public Customer(int id, String customerName, String email, String phoneNumber) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public Customer(String customerName, String email, String phoneNumber) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	} 
	
	
}
