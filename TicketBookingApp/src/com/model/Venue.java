package com.model;

public class Venue {
	private int id; 
	private String venueName; 
	private String address;
	
	public Venue() { }

	public Venue(int id, String venueName, String address) {
		super();
		this.id = id;
		this.venueName = venueName;
		this.address = address;
	}

	public Venue(String venueName, String address) {
		super();
		this.venueName = venueName;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", venueName=" + venueName + ", address=" + address + "]";
	} 
	
	
}
