package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dto.EventRevenueDto;
import com.dto.EventTicketDto;
import com.exception.InvalidIdException;
import com.model.Customer;
import com.model.Event;
import com.service.EventService;

public class EventController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EventService  eventService  = new EventService();
		while (true) {
			System.out.println("*********Event OPS**********");
			System.out.println("Press 1. To calculate total revenue");
			System.out.println("Press 2. Booked ticket Details");
			System.out.println("Press 3. Book the ticket");
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
				/* This op is similar to case 1. 
				 * In case 1, we compute the revenue for each event. 
				 * IN this case, we compute total bookings done. 
				 * So the query will be
				 *  
				 * select event_name, SUM(total_seats-available_seats) as total_tickets_booked 
				 * from event  
				 * group by event_name 
				 *  */
				
				try {
					List<EventTicketDto> list=eventService.getTicketBookedByEvent();
					System.out.println("Event Name\t\t\t\t   Total Tickets Booked");
					for (EventTicketDto dto : list) {
					System.out.println(
					String.format("%-45s%d", dto.getEventName(), dto.getTicketBooked()));
					}
					} catch (SQLException e) {
					System.out.println(e.getMessage());
					}
				break;
			case 3: 
				System.out.println("Enter your ID: ");
				int customerId = sc.nextInt();			
				try {
					/* Step 1:  Validate customerId */
					Customer customer = eventService.validateCustomerId(customerId);
					System.out.println(customer);
					/* Step 2:  Show event details and read ID: eventID */
					List<Event> list = eventService.fetchAllEvents();
					for(Event e : list) {
						System.out.println(e.getId() + "\t" + e.getEventName() + "\t Available Seats:" + e.getAvailableSeats() + 
								"\t Ticket Cost/person" + e.getTicketPrize() + "\t" + e.getEventType());
					}
					System.out.println("Enter event ID to book ticket: ");
					int eventId = sc.nextInt();
					System.out.println("Enter number of Tickets to book: ");
					int numberOfTickets = sc.nextInt();
					/* Check if availableSeats>numberOfTickets */
					//fetch event based on id and do comparision 
					boolean isAvailable = eventService.isTicketAvailable(list,eventId,numberOfTickets);
					if(isAvailable == false) {
						System.out.println("Tickets not available");
						break; 
					}
					/* Step 3: Insert record in booking table.  */
					eventService.insertRecordInBooking(list,customerId,eventId,numberOfTickets);
					
					/* Step 4: deduct available seats from events. */
					eventService.updateAvalableSeats(list,eventId,numberOfTickets);
					System.out.println("Booking confirmed");
				} catch (SQLException | InvalidIdException e) {
					 System.out.println(e.getMessage());
					 break;
				}
				System.out.println("Ticket booked successfully");
				break;
			default:
				break; 
			}
		}//while ends
	}//main ends
}//class ends 
