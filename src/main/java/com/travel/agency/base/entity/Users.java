package com.travel.agency.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "passsword")
	private String password;

	@Column(name = "role")
	private String role;

	@Column(name = "is_enabled")
	private boolean enabled;

	@OneToOne
	@JoinColumn(name = "customerId", referencedColumnName = "customer_id")
	private Customer customer_id;

	public Users() {
	}

	public Users(String username, String password, Customer customerId) {
		this.username = username;
		this.password = password;
		this.customer_id = customerId;
		this.enabled = true;
		this.role = "USER";
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", role=" + role + ", enabled=" + enabled
				+ ", customer_id=" + customer_id + "]";
	}

}
