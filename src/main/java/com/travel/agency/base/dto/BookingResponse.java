package com.travel.agency.base.dto;

import java.time.LocalDate;

public class BookingResponse {
	
	private int bookingId;
	
	private LocalDate bookingDate;

	private LocalDate journeyDate;

	private String source;

	private String destination;

	private String boardingPoint;

	private String dropPoint;

	private int numberOfPassengers;

	public BookingResponse() {}

	public BookingResponse(int bookingId, LocalDate bookingDate, LocalDate journeyDate, String source, String destination,
			String boardingPoint, String dropPoint, int numberOfPassengers) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.source = source;
		this.destination = destination;
		this.boardingPoint = boardingPoint;
		this.dropPoint = dropPoint;
		this.numberOfPassengers = numberOfPassengers;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	@Override
	public String toString() {
		return "BookingResponse [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", journeyDate="
				+ journeyDate + ", source=" + source + ", destination=" + destination + ", boardingPoint="
				+ boardingPoint + ", dropPoint=" + dropPoint + ", numberOfPassengers=" + numberOfPassengers + "]";
	}

	
}
