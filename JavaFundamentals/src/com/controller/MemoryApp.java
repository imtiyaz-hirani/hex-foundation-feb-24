package com.controller;

import com.service.MemoryService;

public class MemoryApp {
	public static void main(String[] args) {
		MemoryService ms1 = new MemoryService();
		MemoryService ms2 = new MemoryService();
		
		ms1.setX(10);
		ms1.setY(4);
		
		System.out.println(ms1.getX()); //10
		System.out.println(ms2.getX()); //5
		
		System.out.println(ms1.getY()); //4
		System.out.println(ms2.getY()); //0
		
		System.out.println(ms1); //123772c4
		System.out.println(ms2); //2d363fb3
	}
}
/* 
 * MemoryService ms1 : reference variable (ms1)
 * new MemoryService() : object  
 */

