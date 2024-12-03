package com.travel.agency.base.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.agency.base.dao.BookingRequest;
import com.travel.agency.base.dto.BookingResponse;
import com.travel.agency.base.entity.Booking;
import com.travel.agency.base.exceptions.NoBookingsFoundException;
import com.travel.agency.base.repository.BookingRepository;
import com.travel.agency.base.service.intf.IBookingService;
import com.travel.agency.base.utility.AgencyUtility;

@Service
public class BookingService implements IBookingService{
	
	private BookingRepository bookingRepository;
	private AgencyUtility utility;
	
	@Autowired
	public BookingService (BookingRepository bookingRepository,AgencyUtility utility ) {
		this.bookingRepository = bookingRepository;
		this.utility = utility;
	}

	@Override
	public List<BookingResponse> getAllBookings() {
		List<Booking> list = bookingRepository.findAll();
		if(list.size() == 0) throw new NoBookingsFoundException("No bookings found");
		List<BookingResponse> listOfResponse = list.stream().map(item -> utility.mapToBookingResponse(item)).collect(Collectors.toList());
		return listOfResponse;
	}

	@Override
	public BookingResponse getBookingById(int bookingId) {
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		if(booking.isEmpty()) throw new NoBookingsFoundException("Booking not found for id: "+bookingId);
		BookingResponse response = utility.mapToBookingResponse(booking.get());
		return response;
	}

	@Override
	public BookingResponse addNewBooking(BookingRequest bookingRequest) {
		Booking booking = utility.mapFromBookingRequest(bookingRequest);
		Booking savedBooking = bookingRepository.save(booking);
		BookingResponse response = utility.mapToBookingResponse(savedBooking);
		return response;	
	}

	@Override
	public BookingResponse updateBooking(int bookingId, BookingRequest request) {
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		if(booking.isEmpty()) throw new NoBookingsFoundException("Booking not found for id: "+bookingId);
		Booking updatedBooking = utility.updateFromBookingRequest(booking.get(), request);
		bookingRepository.save(updatedBooking);
		BookingResponse response = utility.mapToBookingResponse(updatedBooking);
		return response;
	}

	@Override
	public void deleteBookingById(int bookingId) {
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		if(booking.isEmpty()) throw new NoBookingsFoundException("Booking not found for id: "+bookingId);
		bookingRepository.deleteById(bookingId);
	}
	
	

}
