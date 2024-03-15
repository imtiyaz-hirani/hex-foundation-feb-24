package com.model;

import java.time.LocalDate;

public class Booking {
	private int eventId; 
	private int customerId; 
	private int numTickets;
	private double totalCost; 
	private LocalDate bookingDate;
	
	public Booking() { }

	public Booking(int eventId, int customerId, int numTickets, double totalCost, LocalDate bookingDate) {
		super();
		this.eventId = eventId;
		this.customerId = customerId;
		this.numTickets = numTickets;
		this.totalCost = totalCost;
		this.bookingDate = bookingDate;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(int numTickets) {
		this.numTickets = numTickets;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "Booking [eventId=" + eventId + ", customerId=" + customerId + ", numTickets=" + numTickets
				+ ", totalCost=" + totalCost + ", bookingDate=" + bookingDate + "]";
	}
	
	
}
