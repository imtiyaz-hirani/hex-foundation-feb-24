package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.EventDaoImpl;
import com.dto.EventRevenueDto;
import com.dto.EventTicketDto;

public class EventService {

	EventDaoImpl eventDaoImpl = new EventDaoImpl();

	public List<EventRevenueDto> getRevenueByEvent() throws SQLException {
		return eventDaoImpl.getRevenueByEvent();
	}

	public double getGrossTotalRevenue(List<EventRevenueDto> list) {
		double totalRevenue = 0;
		for (EventRevenueDto dto : list) {
			totalRevenue = totalRevenue + dto.getTotalRevenue();
		}
		return totalRevenue;
	}

	public List<EventTicketDto> getTicketBookedByEvent() throws SQLException {

		return eventDaoImpl.getTotalTickets();
	}
}
