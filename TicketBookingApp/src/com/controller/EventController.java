package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.EventRevenueDto;
import com.service.EventService;

public class EventController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EventService  eventService  = new EventService();
		while (true) {
			System.out.println("*********Event OPS**********");
			System.out.println("Press 1. To calculate total revenue");
			System.out.println("Press 2. Booked ticket Details");
			System.out.println("Press 0 for exit");
			System.out.println("****************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting.. thank you!!!");
				break;
			} // if ends
			switch(input) {
			case 1:
				try {
					List<EventRevenueDto> list = eventService.getRevenueByEvent();
					for(EventRevenueDto dto : list) {
						System.out.println(dto.getEventName() + "\t" + (dto.getTotalRevenue()/10000000) + " Cr");
					}
					System.out.println("------------------------------------------------");
					System.out.println("Gross Total Revenue: " + eventService.getGrossTotalRevenue(list) / 10000000 + " cr \n");
				} catch (SQLException e) {
					 System.out.println(e.getMessage());
				}
				break;
			case 2:
				break;
			default:
				break; 
			}
		}//while ends
	}//main ends
}//class ends 
