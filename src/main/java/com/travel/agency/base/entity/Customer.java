package com.travel.agency.base.entity;

import java.time.LocalDate;

import com.travel.agency.base.constants.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;

	@Column(name = "name")
	private String name;

	@Column(name = "dob")
	private LocalDate dateOfBirth;

	@Column(name = "Gender")
	private Gender gender;

	@Column(name = "address")
	private String address;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "email",unique = true)
	private String email;
	
	public Customer() {}

	public Customer(String name, LocalDate dateOfBirth, Gender gender, String address, String mobileNumber,
			String email) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public int getUserId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + customerId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", address=" + address + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}

	
	

}
