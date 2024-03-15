package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.EventRevenueDto;

public interface EventDao {
	public List<EventRevenueDto> getRevenueByEvent() throws SQLException ;
}
