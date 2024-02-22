package com.main;

import java.util.Arrays;
//Divide and Conquer technique used for Sorting 
//Algo: MergeSort 

public class A { //service

	public Integer[] sortArry(Integer[] arry) {
		Arrays.sort(arry); //this will sort the array for us
		return arry;
	}

	public int binarySearchOp(Integer[] sortedArry, int e) {
		return Arrays.binarySearch(sortedArry, e);
	} 

}
