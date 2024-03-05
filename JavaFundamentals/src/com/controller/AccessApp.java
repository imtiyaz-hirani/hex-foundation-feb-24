package com.controller;

import com.service.A;

public class AccessApp {
	public static void main(String[] args) {
		A a=  new A(); //since A is public
		// B b=new B(); -- Make B public to let controller create its object. 
		int sum = a.doSum(4,5); //doSUm in A is public
		System.out.println("sum is : " + sum);
		
		/* 
		int sub = a.doSub(5,6); //-CF doSub in A is not public
		System.out.println("Sub is : " + sub);
		*/
		
		a.setTotalMarks(400);
		a.setMarksScored(340);
		
		double percent = a.computePercent();
		
		System.out.println("percent is " + percent);
		
	}
}

/*
 * ctrl+space: code suggestion + code completion - used for auto import as well
 * ctrl+shift+f: for formating the code and identation
 */