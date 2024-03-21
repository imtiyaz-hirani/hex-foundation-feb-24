package com.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestApp {
	
	@BeforeClass
	public static void beforeClass() { //this method belongs to the class
		System.out.println("Before class @BeforeClass");
	}
	@Before
	public void beforeTest() {
		System.out.println("Before test call @Before");
	}
	@Test
	public void testTask() {
		System.out.println("this is my test method having @Test");
	}
	@Test
	public void testTask1() {
		System.out.println("this is my test method no 2 having @Test");
	}	
	@After
	public void afterTest() {
		System.out.println("After test call @After");
	}	
	@AfterClass
	public static void afterClass() { //this method belongs to the class
		System.out.println("After class @AfterClass");
	}
}

/* 
 * Output: 
 * Before class @BeforeClass
Before test call @Before
this is my test method no 2 having @Test
After test call @After
Before test call @Before
this is my test method having @Test
After test call @After
After class @AfterClass
 */