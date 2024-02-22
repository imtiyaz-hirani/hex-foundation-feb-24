package com.main;

public class Person {
	private String name;
	private String pan;
	private int age;
	private String city;
	private String state;

	
	public Person(String name, String pan, int age, String city, String state) {
		super();
		this.name = name;
		this.pan = pan;
		this.age = age;
		this.city = city;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
