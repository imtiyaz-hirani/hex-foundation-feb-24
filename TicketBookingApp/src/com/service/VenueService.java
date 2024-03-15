package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.VenueDaoImpl;
import com.model.Venue;

public class VenueService {

	private VenueDaoImpl venueDaoImpl = new VenueDaoImpl();
	public List<Venue> getAllVenues() throws SQLException {
		 
		return venueDaoImpl.getAllVenues();
	}
	public Venue getVenueById(int id) throws SQLException {	 
		return venueDaoImpl.getVenueById(id);
	}

}
