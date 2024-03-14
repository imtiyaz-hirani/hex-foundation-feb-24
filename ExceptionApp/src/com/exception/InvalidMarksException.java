package com.exception;

public class InvalidMarksException extends Exception{

	private String message; 
	
	public InvalidMarksException(String message) {
		 this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	private static final long serialVersionUID = 1L;

	
	
}
