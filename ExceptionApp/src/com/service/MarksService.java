package com.service;

import com.exception.InvalidMarksException;

public class MarksService {

	public String computeGrade(Double[] marks, double totalMarks) 
	throws InvalidMarksException{
		/* Validations */
		for(double s : marks) {
			 if(s>100 || s<0)
				 throw new InvalidMarksException("Invalid marks value given: " + s);
		 }
		 
		 double marksScored = 0; 
		 
		 for(double s : marks) {
			 marksScored = marksScored + s;
		 }
		 
		 double percent = (marksScored / totalMarks) * 100; 

		 if(percent > 75)
			 return "A";
		 
		 if(percent > 60)
			 return "B";
		 
		 if(percent > 45)
			 return "C";
		 
		return "D";
	}

}
