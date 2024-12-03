package com.travel.agency.base.service.intf;

import java.util.List;

import com.travel.agency.base.dao.DriverRequest;
import com.travel.agency.base.dto.DriverResponse;

public interface IDriverService {

	List<DriverResponse> getListOfDrivers();

	DriverResponse getDriverById(int driverId);

	DriverResponse addDriver(DriverRequest driverRequest);

	void deleteDriverById(int driverId);

	DriverResponse updateDriverById(int driverId, DriverRequest driverRequest);

}
