package com.main;

public class DynamicService { 
	//recursion- dynamic programming 

	public int fact(int n) {  //n * fact(n-1)	 
		if(n == 1)
			return 1; 
		return n * fact(n-1);
	}
	
}
