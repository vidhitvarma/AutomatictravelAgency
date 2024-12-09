package com.travel.agency.base.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.agency.base.dao.CustomerRequest;
import com.travel.agency.base.dto.CustomerResponse;
import com.travel.agency.base.entity.Customer;
import com.travel.agency.base.exceptions.CustomerNotFoundException;
import com.travel.agency.base.repository.CustomerRepository;
import com.travel.agency.base.service.intf.ICustomerService;
import com.travel.agency.base.utility.AgencyUtility;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository repository;
	@Autowired
	private AgencyUtility agencyUtility;

	@Override
	public CustomerResponse createNewCustomer(CustomerRequest request) {
		Customer customer = agencyUtility.mapFromCustomerRequest(request);
		repository.save(customer);
		CustomerResponse response = agencyUtility.mapToCustomerResponse(customer);
		return response;
	}

	@Override
	public CustomerResponse getCustomerById(int customerId) {
		Optional<Customer> customerFound = repository.findById(customerId);

		if (customerFound.isEmpty())
			throw new CustomerNotFoundException("Customer not found for id:" + customerId);
		CustomerResponse response = agencyUtility.mapToCustomerResponse(customerFound.get());
		return response;
	}

	@Override
	public void deleteCustomerById(int customerId) {
		Optional<Customer> customerFound = repository.findById(customerId);

		if (customerFound.isEmpty())
			throw new CustomerNotFoundException("Customer not found for id:" + customerId);
		repository.deleteById(customerId);

	}

}
