package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.dto.EventRevenueDto;
import com.dto.EventTicketDto;
import com.enums.EventType;
import com.exception.InvalidIdException;
import com.model.Customer;
import com.model.Event;
import com.model.Venue;
import com.util.DBUtil;

public class EventDaoImpl implements EventDao{

	@Override
	public List<EventRevenueDto> getRevenueByEvent() throws SQLException {
		List<EventRevenueDto> list = new ArrayList<>();
		 Connection conn = DBUtil.getDBConn();
		 String sql="select event_name, SUM(((total_seats-available_seats) * ticket_price)) as total_revenue "
		 		+ " from event "
		 		+ " group by event_name";
		 
		 PreparedStatement pstmt = conn.prepareStatement(sql);	
			/* execute the statement */
			ResultSet rst= pstmt.executeQuery();
			
			while(rst.next()) {
				String eventName = rst.getString("event_name");
				double totalRevenue = rst.getDouble("total_revenue");
				EventRevenueDto dto = new EventRevenueDto(eventName, totalRevenue);
				list.add(dto);
			}
		 DBUtil.dbClose();
		return list;
	}
	
	
	public List<EventTicketDto> getTotalTickets() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getDBConn();
		List<EventTicketDto> list=new ArrayList<>();
		String sql="select event_name,SUM(total_seats-available_seats) as ticket_booked from event group by event_name";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while (rst.next()) {
			String eventName=rst.getString("event_name");
			int ticketBooked=rst.getInt("ticket_booked");
			EventTicketDto dto=new EventTicketDto(eventName,ticketBooked);
			list.add(dto);
		}
		DBUtil.dbClose();
		return list;
	}


	public Customer validateCustomerId(int customerId) throws SQLException,InvalidIdException {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from customer where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		if(rst.next()) { //if id is present in the DB, I vl give customer obj else will throw InvalidIdException
			int id = rst.getInt("id");
			String customerName = rst.getString("customer_name");
			String email = rst.getString("email");
			String phoneNumber = rst.getString("phone_number");
			//save it in an object
			Customer customer = new Customer(id, customerName, email, phoneNumber);
			return customer; 
		}
		DBUtil.dbClose();
		throw new InvalidIdException("customer ID given is Invalid");
	}


	@Override
	public List<Event> fetchAllEvents() throws SQLException {
		List<Event> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();
		/* Step 1: Prepare the statement */
		String sql="select * from event";
		PreparedStatement pstmt = conn.prepareStatement(sql);	
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		/* iterate over the result set and read DB column*/
		while(rst.next()) {
			int id = rst.getInt("id");
			String eventName = rst.getString("event_name");
			int availableSeats = rst.getInt("available_seats");
			double ticketPrice = rst.getDouble("ticket_price");
			String eventType = rst.getString("event_type");
			//save it in an object
			Event event = new Event();
			event.setId(id);
			event.setEventName(eventName);
			event.setAvailableSeats(availableSeats);
			event.setTicketPrize(ticketPrice);
			event.setEventType(EventType.valueOf(eventType.toUpperCase()));
			//add this obj to the list. 
			list.add(event);
		}
		DBUtil.dbClose();
		return list;
	}


	@Override
	public void insertRecordInBooking(int customerId, int eventId, int numberOfTickets, double totalCost,
			LocalDate date) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql="insert into booking values (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, eventId);
		pstmt.setInt(2, customerId);
		pstmt.setInt(3, numberOfTickets);
		pstmt.setDouble(4, totalCost);
		pstmt.setString(5, date.toString());
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}


	@Override
	public void updateAvailableSeats(int eventId, int newVal) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql="update event SET available_seats=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, newVal);
		pstmt.setInt(2, eventId);
		
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}
	
}
