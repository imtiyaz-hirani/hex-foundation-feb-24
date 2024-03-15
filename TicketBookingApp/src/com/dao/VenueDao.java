package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Venue;

public interface VenueDao {
	public List<Venue> getAllVenues() throws SQLException;
	public Venue getVenueById(int id)  throws SQLException;
}
