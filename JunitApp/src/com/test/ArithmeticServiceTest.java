package com.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.service.ArithmeticService;

public class ArithmeticServiceTest {

	ArithmeticService arithmeticService = new ArithmeticService();
	
	@Test
	public void sumTest() {
		int num1=10;
		int num2=20;
		Assert.assertEquals(30,arithmeticService.sum(num1, num2));
		num1=-5;
		num2=10;
		Assert.assertEquals(5,arithmeticService.sum(num1, num2));
		num1=0;
		num2=10;
		//Assert.assertEquals(9,arithmeticService.sum(num1, num2));
	}
	
	
	@Test
	public void sumOfArrayTest() {
		int[] arry = {3,1,6,7,2};
		Assert.assertEquals(19, arithmeticService.sumOfArray(arry));
		int[] arry1 = {5,4,7};
		//Assert.assertEquals(15, arithmeticService.sumOfArray(arry1));
	}
	
	@Test //test case 
	public void sortListTest() {
		/* Use Case 1: ASC */
		List<Integer> list = Arrays.asList(4,2,1,7,5);
		String direction="ASC";
		List<Integer> expectedList = Arrays.asList(1,2,4,5,7);		
		Assert.assertEquals(expectedList, 
				arithmeticService.sortList(list, direction));
		
		/* Use Case 2: DESC*/
		list = Arrays.asList(4,2,1,7,5);
		direction="DESC";
		expectedList = Arrays.asList(7,5,4,2,1);
		Assert.assertEquals(expectedList, 
				arithmeticService.sortList(list, direction));		
	
		/* Use Case 3: INVALID_VALUE*/
		list = Arrays.asList(4,2,1,7,5);
		direction="INVALID_VALUE";
		expectedList = Arrays.asList(4,2,1,7,5);
		Assert.assertEquals(expectedList, 
				arithmeticService.sortList(list, direction));		

	}
}

/* 
 * org.junit
 *   |
 * Assert (assertEquals) - static
 *   
 * Assert.assertEquals  
 * */
