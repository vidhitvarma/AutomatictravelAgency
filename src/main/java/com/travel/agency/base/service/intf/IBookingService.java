package com.travel.agency.base.service.intf;

import java.util.List;

import com.travel.agency.base.dao.BookingRequest;
import com.travel.agency.base.dto.BookingResponse;

public interface IBookingService {

	List<BookingResponse> getAllBookings();

	BookingResponse getBookingById(int bookingId);

	BookingResponse addNewBooking(BookingRequest bookingRequest);

	BookingResponse updateBooking(int bookingId, BookingRequest request);

	void deleteBookingById(int bookingId);

}
