package com.main;

public class DynamicDemo {
	public static void main(String[] args) {
		DynamicService ds = new DynamicService();
		int result = ds.fact(5);
		System.out.println("Factorial is " + result );
	}
}


