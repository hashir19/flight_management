package com.hashir.flightmanagement.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
