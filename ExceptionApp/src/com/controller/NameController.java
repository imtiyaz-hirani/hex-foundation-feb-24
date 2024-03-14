package com.controller;

import java.util.Scanner;

import com.exception.InvalidInputException;
import com.service.NameService;

public class NameController {
	public static void main(String[] args) {
		NameService nameService = new NameService();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first Name");
		String fname = sc.next();
		
		System.out.println("Enter last Name");
		String lname = sc.next();
		
		System.out.println("Enter City");
		String city = sc.next();
			
		try {
			double roi = nameService.processInfo(fname,lname,city);
			System.out.println("ROI for your loan would be " + roi);

		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}
}
