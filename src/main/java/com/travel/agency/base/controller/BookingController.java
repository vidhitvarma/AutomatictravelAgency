package com.travel.agency.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.agency.base.dao.BookingRequest;
import com.travel.agency.base.dto.BookingResponse;
import com.travel.agency.base.entity.Booking;
import com.travel.agency.base.service.intf.IBookingService;

@RestController
@RequestMapping("/api")
public class BookingController {
	
	private IBookingService bookingService;
	
	@Autowired
	public BookingController(IBookingService bookingService) {
		this.bookingService = bookingService;
	}

	@GetMapping("/booking")
	public List<BookingResponse> getAllBookings() {
		List<BookingResponse> listOfResponse = bookingService.getAllBookings();
		return listOfResponse;
	}
	
	@GetMapping("/booking/{bookingId}")
	public BookingResponse getBookById(@PathVariable int bookingId) {
		return bookingService.getBookingById(bookingId);
	}
	
	@PostMapping("/booking")
	public BookingResponse addNewBooking(@RequestBody BookingRequest bookingRequest) {
		BookingResponse newBooking = bookingService.addNewBooking(bookingRequest);
		return newBooking;
	}
	
	@PutMapping("/booking/{bookingId}")
	public BookingResponse updateExistingBooking(@PathVariable int bookingId, @RequestBody BookingRequest request) {
		BookingResponse response = bookingService.updateBooking(bookingId, request);
		return response;
	}
	
	@DeleteMapping("/booking/{bookingId}")
	public void deleteBooking(@PathVariable int bookingId) {
		bookingService.deleteBookingById(bookingId);
	}
}
