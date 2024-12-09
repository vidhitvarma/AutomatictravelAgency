package com.travel.agency.base.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {
	
	public CustomerAlreadyExistsException(String msg) {
		super(msg);
	}

}
