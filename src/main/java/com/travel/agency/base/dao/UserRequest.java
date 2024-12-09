package com.travel.agency.base.dao;

public class UserRequest {
	
	private String username;
	private String password;
	private int customerId;
	
	public UserRequest() {}
	
	public UserRequest(String username, String password, int customerId) {
		this.username = username;
		this.password = password;
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "UserRequest [username=" + username + ", password=" + password + ", customerId=" + customerId + "]";
	}
	
	

}
