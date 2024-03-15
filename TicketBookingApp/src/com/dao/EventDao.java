package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.dto.EventRevenueDto;
import com.dto.EventTicketDto;
import com.exception.InvalidIdException;
import com.model.Customer;
import com.model.Event;

public interface EventDao {
	public List<EventRevenueDto> getRevenueByEvent() throws SQLException ;
	List<EventTicketDto> getTotalTickets() throws SQLException;
	public Customer validateCustomerId(int customerId) throws SQLException,InvalidIdException;
	public List<Event> fetchAllEvents() throws SQLException ;
	public void insertRecordInBooking(int customerId, int eventId, int numberOfTickets, double totalCost,
			LocalDate now) throws SQLException;
	public void updateAvailableSeats(int eventId, int i) throws SQLException;
}
