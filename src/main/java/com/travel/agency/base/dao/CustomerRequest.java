package com.travel.agency.base.dao;

import java.time.LocalDate;

import com.travel.agency.base.constants.Gender;

public class CustomerRequest {

	private String name;

	private LocalDate dateOfBirth;

	private String email;

	private String gender;

	private String address;

	private String mobileNumber;
	
	public CustomerRequest() {}

	public CustomerRequest(String name, LocalDate dateOfBirth, String email, String gender, String address,
			String mobileNumber) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		return "CustomerRequest [name=" + name + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", gender="
				+ gender + ", address=" + address + ", mobileNumber=" + mobileNumber + "]";
	}
	
	

}
