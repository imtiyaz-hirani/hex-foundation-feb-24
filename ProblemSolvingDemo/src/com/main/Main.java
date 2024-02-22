package com.main;

public class Main{
	
	public static void main(String[] args) {
		 /* Reach out to class A */
	    A aObj=new A();
	    
	    Integer[] arry = {3,4,1,6,9,2};
	    Integer[] sortedArry = aObj.sortArry(arry);
        	    
	    for(int e : sortedArry){ //e=1 e=2 e=3 e=4 e=6 e=9
	        System.out.print(e + " "); // 1 2 3 4 6 9
	    }
	  
	    System.out.println("\n --------Binary Search-Divide and Conquer Technique---------\n");
	    int result = aObj.binarySearchOp(sortedArry,4);
	    if(result >=0 )
	        System.out.println("Element is present");
	   else
	        System.out.println("Element is not present");
	}
}