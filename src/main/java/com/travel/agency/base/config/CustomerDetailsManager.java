package com.travel.agency.base.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.travel.agency.base.entity.Customer;
import com.travel.agency.base.exceptions.CustomerNotFoundException;
import com.travel.agency.base.repository.CustomerRepository;

public class CustomerDetailsManager implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> customer =customerRepository.findByEmail(username);
		if(customer.isEmpty()) throw new CustomerNotFoundException("Customer not found for emailId: "+username);
		Customer foundCustomer = customer.get();
		return User.withUsername(foundCustomer.getName()).password(foundCustomer.getMobileNumber()).build();
		
	}

}
