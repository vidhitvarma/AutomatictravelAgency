package com.travel.agency.base.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.travel.agency.base.dao.DriverRequest;
import com.travel.agency.base.dto.DriverResponse;
import com.travel.agency.base.entity.Driver;
import com.travel.agency.base.exceptions.DriverAlreadyExistsException;
import com.travel.agency.base.exceptions.DriverNotFoundException;
import com.travel.agency.base.exceptions.NoDriversFoundException;
import com.travel.agency.base.repository.DriverRepository;
import com.travel.agency.base.service.intf.IDriverService;
import com.travel.agency.base.utility.AgencyUtility;

@Service
public class DriverService implements IDriverService {

	private DriverRepository driverRepository;

	@Autowired
	private AgencyUtility agencyUtility;

	@Autowired
	public DriverService( DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

//	Get List Of Drivers
	@Override
	public List<DriverResponse> getListOfDrivers() {
		List<Driver> listOfDrivers = driverRepository.findAll();
		if (listOfDrivers.size() > 0) {
			List<DriverResponse> responseList = listOfDrivers.stream()
					.map(driverData -> agencyUtility.mapToDriverResponse(driverData)).collect(Collectors.toList());
			return responseList;

		}
		else
			throw new NoDriversFoundException("No drivers available in data");
	}

//	Get Driver by id
	@Override
	public DriverResponse getDriverById(int driverId) {
		Optional<Driver> driver = driverRepository.findById(driverId);
		if (driver.isPresent()) {
			DriverResponse response = agencyUtility.mapToDriverResponse(driver.get());
			return response;
		} else
			throw new DriverNotFoundException("Driver not found for driverId: " + driverId);
	}

//  Add Driver
	@Override
	public DriverResponse addDriver(DriverRequest driverRequest) {
		Optional<Driver> driverByLicense = driverRepository.findByDriverLicense(driverRequest.getDriverLicense());
		if (!driverByLicense.isEmpty())
			throw new DriverAlreadyExistsException("Driver already exists");
		else {
			Driver newDriver = agencyUtility.mapFromDriverRequest(driverRequest);
			driverRepository.save(newDriver);
			DriverResponse response = agencyUtility.mapToDriverResponse(newDriver);
			return response;
		}

	}

//  Update driver
	@Override
	public DriverResponse updateDriverById(int driverId, DriverRequest driverRequest) {
		Optional<Driver> fetchedDriver = driverRepository.findById(driverId);
		if (!fetchedDriver.isPresent())
			throw new DriverNotFoundException("Driver not found for Id: " + driverId);
		Driver updatedDriver = fetchedDriver.get();
		updatedDriver.setAddress(driverRequest.getAddress());
		updatedDriver.setDriverName(driverRequest.getDriverName());
		updatedDriver.setDriverLicense(driverRequest.getDriverLicense());
		updatedDriver.setMobileNumber(driverRequest.getContactNumber());
		driverRepository.save(updatedDriver);
		DriverResponse updatedResponse = agencyUtility.mapToDriverResponse(updatedDriver);
		return updatedResponse;

	}

//	Delete driver
	@Override
	public void deleteDriverById(int driverId) {
		Optional<Driver> driverByLicense = driverRepository.findById(driverId);
		if (!driverByLicense.isPresent())
			throw new DriverNotFoundException("Driver not found for Id: " + driverId);
		else
			driverRepository.deleteById(driverId);

	}

}
