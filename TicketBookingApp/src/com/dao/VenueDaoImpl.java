package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Venue;
import com.util.DBUtil;

public class VenueDaoImpl implements VenueDao{

	@Override
	public List<Venue> getAllVenues() throws SQLException {
		List<Venue> list = new ArrayList<>();
		Connection conn = DBUtil.getDBConn();
		/* Step 1: Prepare the statement */
		String sql="select * from venue";
		PreparedStatement pstmt = conn.prepareStatement(sql);	
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		/* iterate over the result set and read DB column*/
		while(rst.next()) {
			int id = rst.getInt("id");
			String venueName = rst.getString("venue_name");
			String address = rst.getString("address");
			//save it in an object
			Venue venue = new Venue(id,venueName,address);
			//add this obj to the list. 
			list.add(venue);
		}
		DBUtil.dbClose();
		return list;
	}

	@Override
	public Venue getVenueById(int id) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		/* Step 1: Prepare the statement */
		String sql="select * from venue where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		/* Attach the value of param ? */
		pstmt.setInt(1, id);
		/* execute the statement */
		ResultSet rst= pstmt.executeQuery();
		/* iterate over the result set and read DB column*/
		if(rst.next()) { //if id is present in the DB, I vl give venue obj else will throw NPE
			int vid = rst.getInt("id");
			String venueName = rst.getString("venue_name");
			String address = rst.getString("address");
			//save it in an object
			Venue venue = new Venue(id,venueName,address);
			return venue; 
		}
		DBUtil.dbClose();
		throw new NullPointerException("Invalid ID Given");
	}

	
}
