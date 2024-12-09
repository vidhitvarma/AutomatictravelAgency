package com.travel.agency.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.agency.base.dao.CustomerRequest;
import com.travel.agency.base.dto.CustomerResponse;
import com.travel.agency.base.service.intf.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping("/customer")
	public CustomerResponse addnewCustomer(@RequestBody CustomerRequest request) {
		CustomerResponse response = customerService.createNewCustomer(request);
		return response;
	}
	
	@GetMapping("/customer/{customerId}")
	public CustomerResponse getCustomerById(@PathVariable int customerId) {
		CustomerResponse customer = customerService.getCustomerById(customerId);
		return customer;
	}
	
	@DeleteMapping("/customer/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomerById(customerId);
	}

}
