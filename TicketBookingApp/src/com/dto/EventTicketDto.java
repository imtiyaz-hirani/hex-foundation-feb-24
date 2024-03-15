package com.dto;

public class EventTicketDto {
	private String eventName;
	private int ticketBooked;

	public EventTicketDto(String eventName, int ticketBooked) {
		super();
		this.eventName = eventName;
		this.ticketBooked = ticketBooked;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getTicketBooked() {
		return ticketBooked;
	}

	public void setTicketBooked(int ticketBooked) {
		this.ticketBooked = ticketBooked;
	}

	@Override
	public String toString() {
		return "EventTicketDto [eventName=" + eventName + ", ticketBooked=" + ticketBooked + "]";
	}

}
