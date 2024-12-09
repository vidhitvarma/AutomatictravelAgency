package com.travel.agency.base.service.intf;

import com.travel.agency.base.dao.CustomerRequest;
import com.travel.agency.base.dto.CustomerResponse;

public interface ICustomerService {

	CustomerResponse createNewCustomer(CustomerRequest request);

	CustomerResponse getCustomerById(int customerId);

	void deleteCustomerById(int customerId);

}
