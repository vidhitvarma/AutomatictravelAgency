package com.travel.agency.base.dao;

import java.time.LocalDate;

public class BookingRequest {
	private LocalDate bookingDate;

	private LocalDate journeyDate;

	private String source;

	private String destination;

	private String boardingPoint;

	private String dropPoint;

	private int numberOfPassengers;

	public BookingRequest() {
	}

	public BookingRequest(LocalDate bookingDate, LocalDate journeyDate, String source, String destination,
			String boardingPoint, String dropPoint, int numberOfPassengers) {
		super();
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.source = source;
		this.destination = destination;
		this.boardingPoint = boardingPoint;
		this.dropPoint = dropPoint;
		this.numberOfPassengers = numberOfPassengers;
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
		return "BookingRequest [bookingDate=" + bookingDate + ", journeyDate=" + journeyDate + ", source=" + source
				+ ", destination=" + destination + ", boardingPoint=" + boardingPoint + ", dropPoint=" + dropPoint
				+ ", numberOfPassengers=" + numberOfPassengers + "]";
	}

}
