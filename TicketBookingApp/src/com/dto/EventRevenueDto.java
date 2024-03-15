package com.dto;

public class EventRevenueDto {
	private String eventName;
	private double totalRevenue;
	
	public EventRevenueDto() { }

	public EventRevenueDto(String eventName, double totalRevenue) {
		super();
		this.eventName = eventName;
		this.totalRevenue = totalRevenue;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	@Override
	public String toString() {
		return "EventRevenue [eventName=" + eventName + ", totalRevenue=" + totalRevenue + "]";
	} 
	
	
}
