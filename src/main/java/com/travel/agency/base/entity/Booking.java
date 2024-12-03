package com.travel.agency.base.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@Column(name = "booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@Column(name = "booking_date")
	private LocalDate bookingDate;

	@Column(name = "journey_date")
	private LocalDate journeyDate;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "boarding_point")
	private String boardingPoint;

	@Column(name = "drop_point")
	private String dropPoint;

	@Column(name = "number_of_passengers")
	private int numberOfPassengers;

	public Booking() {
		super();
	}

	public Booking(LocalDate bookingDate, LocalDate journeyDate, String source, String destination,
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

	public int getBookingId() {
		return bookingId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate
				+ ", source=" + source + ", destination=" + destination + ", boardingPoint=" + boardingPoint
				+ ", dropPoint=" + dropPoint + ", numberOfPassengers=" + numberOfPassengers + "]";
	}

}
