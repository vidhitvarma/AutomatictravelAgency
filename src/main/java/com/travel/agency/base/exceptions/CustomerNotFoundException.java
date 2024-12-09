package com.travel.agency.base.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String msg) {
		super(msg);
	}

}
