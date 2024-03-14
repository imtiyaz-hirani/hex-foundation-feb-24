package com.exception;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = -1245961911209216056L;
	
	private String message;
	
	public InvalidInputException(String message) {
		 this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
