package com.travel.agency.base.utility;

import org.springframework.stereotype.Component;

import com.travel.agency.base.constants.Gender;
import com.travel.agency.base.constants.VehicleType;
import com.travel.agency.base.dao.BookingRequest;
import com.travel.agency.base.dao.CustomerRequest;
import com.travel.agency.base.dao.DriverRequest;
import com.travel.agency.base.dao.RouteRequest;
import com.travel.agency.base.dao.VehicleRequest;
import com.travel.agency.base.dto.BookingResponse;
import com.travel.agency.base.dto.CustomerResponse;
import com.travel.agency.base.dto.DriverResponse;
import com.travel.agency.base.dto.RouteResponse;
import com.travel.agency.base.dto.VehicleResponse;
import com.travel.agency.base.entity.Booking;
import com.travel.agency.base.entity.Customer;
import com.travel.agency.base.entity.Driver;
import com.travel.agency.base.entity.Route;
import com.travel.agency.base.entity.Vehicle;

@Component
public class AgencyUtility {

	// driver response
	public DriverResponse mapToDriverResponse(Driver driver) {
		DriverResponse response = new DriverResponse();
		response.setContactNumber(driver.getMobileNumber());
		response.setName(driver.getDriverName());
		response.setDriverId(driver.getDriverId());
		return response;
	}

	// driver request
	public Driver mapFromDriverRequest(DriverRequest driverRequest) {
		Driver driver = new Driver();
		driver.setDriverName(driverRequest.getDriverName());
		driver.setAddress(driverRequest.getAddress());
		driver.setDriverLicense(driverRequest.getDriverLicense());
		driver.setMobileNumber(driverRequest.getContactNumber());
		return driver;
	}

	// route response
	public RouteResponse mapToRouteResponse(Route route) {
		RouteResponse response = new RouteResponse();
		response.setSource(route.getSource());
		response.setDestination(route.getDestination());
		response.setDurationInHours(route.getDurationInHours());
		response.setDistance(route.getDistance());
		return response;
	}

	// route request
	public Route mapFromRouteRequest(RouteRequest routeRequest, String routeCode) {
		Route route = new Route();
		route.setRouteId(routeCode);
		route.setDistance(routeRequest.getDistance());
		route.setDestination(routeRequest.getDestination());
		route.setSource(routeRequest.getSource());
		route.setDurationInHours(routeRequest.getDurationInHours());
		return route;
	}

	// Vehicle response
	public VehicleResponse mapToVehicleResponse(Vehicle vehicle) {
		VehicleResponse response = new VehicleResponse();
		response.setDriverId(vehicle.getDriverId());
		response.setFarePerKilometer(vehicle.getFarePerKilometer());
		response.setSeatingCapacity(vehicle.getSeatingCapacity());
		response.setVehicleName(vehicle.getVehicleName());
		response.setVehicleNumber(vehicle.getVehicleNumber());
		response.setVehicleType(vehicle.getVehicleType());
		return response;
	}

//	Vehicle request
	public Vehicle mapFromVehicleRequest(VehicleRequest newVehicle, Driver driver) {
		Vehicle vehicle = new Vehicle();
		vehicle.setDriverId(driver);
		vehicle.setFarePerKilometer(newVehicle.getFare());
		vehicle.setSeatingCapacity(newVehicle.getSeatingCapacity());
		vehicle.setVehicleName(newVehicle.getVehicleName());
		vehicle.setVehicleNumber(newVehicle.getVehicleNumber());
		try {
			vehicle.setVehicleType(VehicleType.toEnum(newVehicle.getVehicleType()));
		} catch (Exception e) {
			e.getLocalizedMessage();
		}

		return vehicle;

	}

	public Vehicle mapFromVehicleRequest(VehicleRequest vehicleRequest, Vehicle vehicleToUpdate, Driver driver) {
		Vehicle vehicle = vehicleToUpdate;
		try {
			vehicle.setDriverId(driver);
			vehicle.setFarePerKilometer(vehicleRequest.getFare());
			vehicle.setSeatingCapacity(vehicleRequest.getSeatingCapacity());
			vehicle.setVehicleName(vehicleRequest.getVehicleName());
			vehicle.setVehicleNumber(vehicleRequest.getVehicleNumber());

			vehicle.setVehicleType(VehicleType.toEnum(vehicleRequest.getVehicleType()));
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		return vehicle;

	}

	public BookingResponse mapToBookingResponse(Booking booking) {
		BookingResponse response = new BookingResponse();
		response.setBookingId(booking.getBookingId());
		response.setJourneyDate(booking.getJourneyDate());
		response.setBookingDate(booking.getBookingDate());
		response.setSource(booking.getSource());
		response.setDestination(booking.getDestination());
		response.setBoardingPoint(booking.getBoardingPoint());
		response.setDropPoint(booking.getDropPoint());
		response.setNumberOfPassengers(booking.getNumberOfPassengers());
		
		return response;

	}

	public Booking mapFromBookingRequest(BookingRequest bookingRequest) {
		Booking booking = new Booking();
		booking.setBoardingPoint(bookingRequest.getBoardingPoint());
		booking.setDropPoint(bookingRequest.getDropPoint());
		booking.setBookingDate(bookingRequest.getBookingDate());
		booking.setJourneyDate(bookingRequest.getJourneyDate());
		booking.setSource(bookingRequest.getSource());
		booking.setDestination(bookingRequest.getDestination());
		booking.setNumberOfPassengers(bookingRequest.getNumberOfPassengers());
		
		return booking;
	}

	public Booking updateFromBookingRequest(Booking booking, BookingRequest request) {
		Booking updatedBooking = booking;
		updatedBooking.setBoardingPoint(request.getBoardingPoint());
		updatedBooking.setDropPoint(request.getDropPoint());
		updatedBooking.setBookingDate(request.getBookingDate());
		updatedBooking.setJourneyDate(request.getJourneyDate());
		updatedBooking.setSource(request.getSource());
		updatedBooking.setDestination(request.getDestination());
		updatedBooking.setNumberOfPassengers(request.getNumberOfPassengers());
		return updatedBooking;
	}

	public Customer mapFromCustomerRequest(CustomerRequest customerRequest) {
		Customer customer  = new Customer();
		try {
			customer.setAddress(customerRequest.getAddress());
			customer.setDateOfBirth(customerRequest.getDateOfBirth());
			customer.setEmail(customerRequest.getEmail());
			customer.setGender(Gender.toEnum(customerRequest.getGender()));
			customer.setMobileNumber(customerRequest.getMobileNumber());
			customer.setName(customerRequest.getName());
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
		return customer;
	}

	public CustomerResponse mapToCustomerResponse(Customer customerToAdd) {
		CustomerResponse response = new CustomerResponse();
		response.setEmail(customerToAdd.getEmail());
		response.setName(customerToAdd.getName());
		return response;
	}



}
