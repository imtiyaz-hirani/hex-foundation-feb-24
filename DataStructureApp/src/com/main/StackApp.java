package com.main;
import java.util.*; 

public class StackApp {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(); //LIFO 
		stack.push(5);
		stack.push(4);
		stack.push(1);
		stack.push(3);
		stack.push(2);
		
		System.out.println("No of elements in Stack: " + stack.size()); //5
		
		int i=0; 
		while(i<5) { //i=0(i<5?yes)
			System.out.println(stack.pop()); //2 3 1 4 5 
			i++;
		}
	}
}
