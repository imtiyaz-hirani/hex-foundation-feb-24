package com.exception;

public class SqlOperationFailedException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public SqlOperationFailedException(String message) {
		 this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
