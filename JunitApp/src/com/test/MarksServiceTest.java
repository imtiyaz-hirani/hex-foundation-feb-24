package com.test;

import org.junit.Assert;
import org.junit.Test;

import com.exception.InvalidMarksException;
import com.service.MarksService;

public class MarksServiceTest {

	MarksService marksService = new MarksService();
	
	@Test
	public void computeGradeTest() {
		/* Use Case 1 : A */
		double[] marks= {78,82,71}; 
		double totalMarks = 300;
		
		try {
			Assert.assertEquals("A", marksService.computeGrade(marks, totalMarks));
		} catch (InvalidMarksException e) { }
		
		/* Use Case 2 : B */
		double[] marks1= {68,82,71}; 
		totalMarks = 300;
		
		try {
			Assert.assertEquals("B", marksService.computeGrade(marks1, totalMarks));
		} catch (InvalidMarksException e) { }
		
		/* Use Case 3 : C */
		double[] marks2= {68,52,51}; 
		totalMarks = 300;
		
		try {
			Assert.assertEquals("C", marksService.computeGrade(marks2, totalMarks));
		} catch (InvalidMarksException e) { }
	
		/* Use Case 4 : Exception for > 100 */
		double[] marks3= {68,152,51}; 
		totalMarks = 300;
		
		try {
			Assert.assertEquals("C", marksService.computeGrade(marks3, totalMarks));
		} catch (InvalidMarksException e) {
			Assert.assertEquals("Marks given > 100", e.getMessage());
		}
		
		/* Use Case 5 : Exception for < 0 */
		double[] marks4= {-68,52,51}; 
		totalMarks = 300;
		
		try {
			Assert.assertEquals("C", marksService.computeGrade(marks4, totalMarks));
		} catch (InvalidMarksException e) {
			Assert.assertEquals("marks given < 0".toLowerCase(), e.getMessage().toLowerCase());
		}
	}
}
