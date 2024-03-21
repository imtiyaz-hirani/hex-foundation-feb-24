package com.service;

import com.exception.InvalidMarksException;

public class MarksService {

	public String computeGrade(double[] marks,
			double totalMarks) 
	throws InvalidMarksException
	{
		/* Validating the marks given in an array */		
		for(double m : marks) {
			if(m > 100)
				throw new InvalidMarksException("Marks given > 100");
			if(m < 0)
				throw new InvalidMarksException("Marks given < 0");
		}
		
		double sumMarks = 0; 
		
		for(double m : marks) { //cumulatively marks scored by student
			sumMarks = sumMarks + m;
		}
		
		double percent = (sumMarks / totalMarks) * 100;		
		if(percent > 75)
			return "A";
		if(percent > 60)
			return "B";
		else
			return "C";		
	}
}
