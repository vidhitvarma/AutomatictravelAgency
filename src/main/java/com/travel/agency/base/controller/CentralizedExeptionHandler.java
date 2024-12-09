package com.travel.agency.base.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.travel.agency.base.error.GenericErrorResponse;
import com.travel.agency.base.exceptions.CustomerAlreadyExistsException;
import com.travel.agency.base.exceptions.DriverAlreadyExistsException;
import com.travel.agency.base.exceptions.DriverNotFoundException;
import com.travel.agency.base.exceptions.NoBookingsFoundException;
import com.travel.agency.base.exceptions.NoDriversFoundException;
import com.travel.agency.base.exceptions.NoRouteFoundException;
import com.travel.agency.base.exceptions.NoVehiclesFoundException;
import com.travel.agency.base.exceptions.RouteAlreadyPresentException;

@ControllerAdvice
public class CentralizedExeptionHandler {
	
//	Driver Exceptions
	@ExceptionHandler(value = NoDriversFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody GenericErrorResponse noDriverFoundExceptionHandler(NoDriversFoundException e) {
		return new GenericErrorResponse(HttpStatus.NOT_FOUND.value(), e.getLocalizedMessage(), System.currentTimeMillis());
	}
	
	@ExceptionHandler(value = DriverNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody GenericErrorResponse driverNotFoundExceptionHandler(DriverNotFoundException e) {
		return new GenericErrorResponse(HttpStatus.NOT_FOUND.value(), e.getLocalizedMessage(), System.currentTimeMillis());
	}
	
	@ExceptionHandler(value = DriverAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody GenericErrorResponse driverAlreadyExistsExceptionHandler(DriverAlreadyExistsException e) {
		return new GenericErrorResponse(HttpStatus.CONFLICT.value(), e.getLocalizedMessage(), System.currentTimeMillis());
	}
	
	@ExceptionHandler(value = NoRouteFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody GenericErrorResponse noRouteFoundExceptionHandler(NoRouteFoundException e) {
		return new GenericErrorResponse(HttpStatus.NOT_FOUND.value(), e.getLocalizedMessage(), System.currentTimeMillis());
	}
	
	@ExceptionHandler(value = RouteAlreadyPresentException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody GenericErrorResponse routeAlreadyExistsExceptionHandler(RouteAlreadyPresentException e) {
		return new GenericErrorResponse(HttpStatus.CONFLICT.value(), e.getLocalizedMessage(), System.currentTimeMillis());
	}
	
	@ExceptionHandler(value = NoVehiclesFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody GenericErrorResponse noVehiclesFoundExceptionHandler(NoVehiclesFoundException e) {
		return new GenericErrorResponse (HttpStatus.NOT_FOUND.value(), e.getLocalizedMessage(), System.currentTimeMillis());
	}
	
	@ExceptionHandler(value = NoBookingsFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody GenericErrorResponse noBookingsFoundExceptionHandler(NoBookingsFoundException e) {
		return new GenericErrorResponse (HttpStatus.NOT_FOUND.value(), e.getLocalizedMessage(), System.currentTimeMillis());
	}
	
	@ExceptionHandler(value = CustomerAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody GenericErrorResponse customerAlreadyExistsExceptionHandler(CustomerAlreadyExistsException e) {
		return new GenericErrorResponse(HttpStatus.CONFLICT.value(), e.getLocalizedMessage(), System.currentTimeMillis());
	}

}
