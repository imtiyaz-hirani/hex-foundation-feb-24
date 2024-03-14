package com.controller;

import java.util.Scanner;

import com.exception.InvalidMarksException;
import com.service.MarksService;
 
public class MarksController {
	 public static void main(String[] args) {
		 MarksService marksService = new MarksService();
		 Scanner sc = new Scanner(System.in);
		 Double[] marks = new Double[3];
		 
		 for(int i=0;i<3;i++) { //i=0,1,2
			 System.out.println("Enter marks for subj" + (i+1) + ": ");
			 marks[i] = sc.nextDouble();
		 }
		 double totalMarks = 300; 
		 
		try {
			String grade = marksService.computeGrade(marks,totalMarks);
			System.out.println("Your grade is " + grade);
		} catch (InvalidMarksException e) {
			 System.out.println(e.getMessage());
		}		
	}
}

/* 
 * Double[] marks = new Double[3];
 * marks = [78,82,67]
 */