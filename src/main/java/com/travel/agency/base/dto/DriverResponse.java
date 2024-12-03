package com.travel.agency.base.dto;

public class DriverResponse {

	private String name;

	private String contactNumber;

	private int driverId;

	public DriverResponse() {
	}

	public DriverResponse(String name, String contactNumber, int driverId) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.driverId = driverId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	@Override
	public String toString() {
		return "DriverResponse [name=" + name + ", contactNumber=" + contactNumber + ", driverId=" + driverId + "]";
	};

}
