package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.EventRevenueDto;
import com.dto.EventTicketDto;
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
	
}
