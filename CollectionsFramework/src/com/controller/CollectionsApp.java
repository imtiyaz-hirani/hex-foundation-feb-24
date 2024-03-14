package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionsApp {
	public static void main(String[] args) {
		/* 2 ways of creating a ArrayList */
		ArrayList<Integer> list1 = new ArrayList<>(); 
		
		List<Integer> list = new ArrayList<>(); //poly 
		list.add(4);
		list.add(3);
		list.add(7);
		//list.add(null);
		
		/* Creating List using Arrays class */
		List<Integer> list2 = Arrays.asList(1,4,2,5,7,3,9);
		
		/* Iterate the list */
		for(int x : list) {
			System.out.print(x + " "); //[4 3 7]
		}
		
		System.out.println("*********Removing element from list*********");
		list.remove(1);
		for(int x : list) {
			System.out.println(x + " ");  //[4,7]
		} 
		
		System.out.println("*********Fetch an element from list*********");
		list.add(2);
		list.add(9); //[4,7,2,9]
		int e = list.get(1); //element that is at index: 1
		System.out.println("Element at index 1: " + e);
		
		System.out.println("*********Sorting the list*********");
		Collections.sort(list);
		System.out.println(list); //[2,4,7,9]
		
		Collections.reverse(list);
		System.out.println(list); //[9,7,4,2]
		
		System.out.println("********Searching from the list**********");
		Collections.sort(list); //[2,4,7,9]
		int pos = Collections.binarySearch(list, 4); //1
		System.out.println("element 4 is at index: " + pos);
	}
}

//5 19   d  y
//employee1 employee2
