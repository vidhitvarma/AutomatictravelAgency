package com.travel.agency.base.dto;

public class RouteResponse {

	private String source;

	private String destination;

	private double distance;

	private int durationInHours;

	public RouteResponse() {

	}

	public RouteResponse(String source, String destination, double distance, int durationInHours) {
		super();
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.durationInHours = durationInHours;
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	@Override
	public String toString() {
		return "RouteResponse [source=" + source + ", destination=" + destination + ", distance=" + distance
				+ ", durationInHours=" + durationInHours + "]";
	}

}
