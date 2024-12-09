package com.travel.agency.base.dto;

public class CustomerResponse {
	private String name;
	private String email;
	
	public CustomerResponse() {}
	
	public CustomerResponse(String name, String email) {
		this.name= name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", email=" + email + "]";
	}
	
	

}
