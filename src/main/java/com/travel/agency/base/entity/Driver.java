package com.travel.agency.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {

	@Id
	@Column(name = "driver_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;

	@Column(name = "driver_license")
	private String driverLicense;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "address")
	private String address;

	@Column(name = "mobile_number")
	private String mobileNumber;

	public Driver() {
	}

	public Driver(String driverName, String address,  String mobileNumber, String driverLicense) {
		super();
		this.driverLicense = driverLicense;
		this.driverName = driverName;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	public int getDriverId() {
		return driverId;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverLicense=" + driverLicense + ", driverName=" + driverName
				+ ", address=" + address + ", mobileNumber=" + mobileNumber + "]";
	}

}
