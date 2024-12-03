package com.travel.agency.base.dao;

public class DriverRequest {

	private String driverName;

	private String address;

	private String contactNumber;

	private String driverLicense;

	public DriverRequest() {

	}

	public DriverRequest(String driverName, String address, String contactNumber, String driverLicense) {
		super();
		this.driverName = driverName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.driverLicense = driverLicense;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	@Override
	public String toString() {
		return "DriverRequest [driverName=" + driverName + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", licenseNumber=" + driverLicense + "]";
	}

}
