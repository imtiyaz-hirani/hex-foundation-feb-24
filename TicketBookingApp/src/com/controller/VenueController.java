package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Venue;
import com.service.VenueService;

public class VenueController {
	public static void main(String[] args) {
		VenueService venueService = new VenueService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*********VENUE OPS**********");
			System.out.println("Press 1. for all venue details");
			System.out.println("Press 2. for specific venue details");
			System.out.println("Press 0 for exit");
			System.out.println("****************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting.. thank you!!!");
				break;
			} // if ends
			switch (input) {
			case 1:
				System.out.println("***ALL VENUE DETAILS****");

				try {
					List<Venue> list = venueService.getAllVenues();
					for (Venue v : list) {
						System.out.println(v);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				System.out.println("***SINGLE VENUE DETAILS***");
				System.out.println("Enter venue ID");
				int id = sc.nextInt();
				
				try {
					Venue venue = venueService.getVenueById(id);
					System.out.println(venue);
				} catch (SQLException e) { //if query goes wring, this handles it
					 System.out.println(e.getMessage());
				}
				catch (NullPointerException e) { //if id is invalid, this handles it 
					System.out.println(e.getMessage());
				}
				
				break;
			default:
				System.out.println("Invalid Input");
			} // end switch
		} // while ends
		sc.close(); // scanner closed.
	} // main ends
} // class ends

//ctrl+shft+f: format
//ctrl + shft+o: import 