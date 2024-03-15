package com.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.enums.EventType;

public class Event {
	private int id; 
	private String eventName; 
	private LocalTime eventTime; 
	private LocalDate eventDate;
	private int totalSeats; 
	private int availableSeats; 
	private double ticketPrize; 
	private EventType eventType; 
	private int venueId;
	
	public Event() { }

	public Event(int id, String eventName, LocalTime eventTime, LocalDate eventDate, int totalSeats, int availableSeats,
			double ticketPrize, EventType eventType, int venueId) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventTime = eventTime;
		this.eventDate = eventDate;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.ticketPrize = ticketPrize;
		this.eventType = eventType;
		this.venueId = venueId;
	}

	public Event(String eventName, LocalTime eventTime, LocalDate eventDate, int totalSeats, int availableSeats,
			double ticketPrize, EventType eventType, int venueId) {
		super();
		this.eventName = eventName;
		this.eventTime = eventTime;
		this.eventDate = eventDate;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.ticketPrize = ticketPrize;
		this.eventType = eventType;
		this.venueId = venueId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public double getTicketPrize() {
		return ticketPrize;
	}

	public void setTicketPrize(double ticketPrize) {
		this.ticketPrize = ticketPrize;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventName=" + eventName + ", eventTime=" + eventTime + ", eventDate=" + eventDate
				+ ", totalSeats=" + totalSeats + ", availableSeats=" + availableSeats + ", ticketPrize=" + ticketPrize
				+ ", eventType=" + eventType + ", venueId=" + venueId + "]";
	}

	 

	
}
