package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dao.EventDao;
import com.dao.EventDaoImpl;
import com.dto.EventRevenueDto;
import com.dto.EventTicketDto;
import com.exception.InvalidIdException;
import com.model.Customer;
import com.model.Event;

public class EventService {

	EventDao eventDao = new EventDaoImpl(); //polymorphic

	public List<EventRevenueDto> getRevenueByEvent() throws SQLException {
		return eventDao.getRevenueByEvent();
	}

	public double getGrossTotalRevenue(List<EventRevenueDto> list) {
		double totalRevenue = 0;
		for (EventRevenueDto dto : list) {
			totalRevenue = totalRevenue + dto.getTotalRevenue();
		}
		return totalRevenue;
	}

	public List<EventTicketDto> getTicketBookedByEvent() throws SQLException {

		return eventDao.getTotalTickets();
	}

	public Customer validateCustomerId(int customerId) throws SQLException, InvalidIdException {
		 
		return eventDao.validateCustomerId(customerId);
	}

	public List<Event> fetchAllEvents() throws SQLException {
		return eventDao.fetchAllEvents();
	}

	public boolean isTicketAvailable(List<Event> list, int eventId, int numberOfTickets) {
		for(Event e : list) {
			if(e.getId() == eventId) {
				if(e.getAvailableSeats() > numberOfTickets)
					return true; 
			}
		}
		return false;
	}

	public void insertRecordInBooking(List<Event> list, int customerId, 
			 int eventId, int numberOfTickets) throws SQLException {
		double totalCost = 0; 
		for(Event e : list) {
			if(e.getId() == eventId) {
				totalCost = e.getTicketPrize() * numberOfTickets;
				break; 
			}
		}
		  
		eventDao.insertRecordInBooking(customerId,eventId,numberOfTickets,totalCost,LocalDate.now());
		
	}

	public void updateAvalableSeats(List<Event> list, int eventId, int numberOfTickets) throws SQLException {
		
		for(Event e : list) {
			if(e.getId() == eventId) {
				eventDao.updateAvailableSeats(eventId, 
					(e.getAvailableSeats() - numberOfTickets)); 
			}
		}
	}
}
