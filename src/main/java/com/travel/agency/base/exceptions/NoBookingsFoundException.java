package com.travel.agency.base.exceptions;

public class NoBookingsFoundException extends RuntimeException{
	public NoBookingsFoundException(String msg) {
		super(msg);
	}

}
