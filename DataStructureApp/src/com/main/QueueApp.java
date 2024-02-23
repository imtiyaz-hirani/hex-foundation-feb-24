package com.main;
import java.util.*; 

public class QueueApp {
	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(2);
		queue.add(5);
		queue.add(6);
		queue.add(1);
		queue.add(7);
		
		System.out.println("No of elements in queue: " +queue.size());//5
		int size = queue.size(); 
		for(int i=0;i<size;i++) { //i=0..1..2..3..4
			System.out.println(queue.remove()); //natural Order: 1 2 5 6 7
		}
		
		System.out.println("-----LinkedList: Insertion Order------");
		queue = new LinkedList<>();
		queue.add(2);
		queue.add(5);
		queue.add(6);
		queue.add(1);
		queue.add(7);
		
		System.out.println("No of elements in queue: " +queue.size());//5
		  
		for(int i=0;i<size;i++) { //i=0..1..2..3..4
			System.out.println(queue.remove());  //insertion order : 2 5 6 1 7
		}
	}
}
