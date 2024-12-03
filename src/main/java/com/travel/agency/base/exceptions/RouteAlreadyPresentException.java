package com.travel.agency.base.exceptions;

public class RouteAlreadyPresentException extends RuntimeException {
	
	public RouteAlreadyPresentException(String msg) {
		super(msg);
	}

}
