package com.main;

public class ArrayApp {
	public static void main(String[] args) {
		/* create an array and save 5 elements in it */
		int[] x = {6,4,8,1,3};
		System.out.println("element at index 2: " + x[2]); //8
		//System.out.println(x[6]); //Array Index OUt Of Bounds Exception 
		System.out.println(x); //memory loc
		
		/* Compute length of the array  */
		System.out.println("length of an array: " + x.length); //5
		//x.length = 10; -- cannot change the length of array : its fixed size DS 
		
		/* Iteration */
		//traditional for loop
		for(int i=0;i<x.length;i++) { //x.length:5   i=0 (i<5?)   i=1
			System.out.print(x[i] + " ");
		} //condition - body - increment 
		System.out.println("\n -----\n");
		
		//for each loop 
		for(int temp :x ) {  //temp=6 4 8
			System.out.print(temp + " "); //6 4 8....
		}
		
		//Alternate way of creating an Array 
		int[] arr = new int[5]; //[0,0,0,0,0]
		System.out.println("\n -----\n");
		
		//for each loop 
		for(int temp :arr ) {  //temp=6 4 8
			System.out.print(temp + " "); //6 4 8....
		}
		
		arr[0] = 5;
		arr[2] = 7;
		arr[4] = 9; 
		
		System.out.println("\n -----\n");
		
		//for each loop 
		for(int temp :arr ) {  //temp=6 4 8
			System.out.print(temp + " "); //6 4 8....
		}
	}
}
