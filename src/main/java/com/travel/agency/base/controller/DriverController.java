package com.travel.agency.base.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.agency.base.dao.DriverRequest;
import com.travel.agency.base.dto.DriverResponse;
import com.travel.agency.base.service.intf.IDriverService;



@RestController
@RequestMapping("/api")
public class DriverController {

	private static final Logger logging = LoggerFactory.getLogger(DriverController.class);

	private IDriverService driverService;

	@Autowired
	public DriverController(IDriverService driverService) {
		this.driverService = driverService;
	}

	@PostMapping("/driver")
	public DriverResponse addDriver(@RequestBody DriverRequest driverRequest) {
		DriverResponse driverResponse = driverService.addDriver(driverRequest);
		return driverResponse;
	}

	@GetMapping("/driver")
	public List<DriverResponse> getListOfDrivers() {
		return driverService.getListOfDrivers();
	}

	@GetMapping("/driver/{driverId}")
	public DriverResponse getDriverById(@PathVariable("driverId") int driverId) {
		return driverService.getDriverById(driverId);
	}

	@PutMapping(value = "/driver/{driverId}")
	public DriverResponse updateDriverById(@PathVariable("driverId") int driverId,
			@RequestBody DriverRequest driverRequest) {
		DriverResponse driverResponse = driverService.updateDriverById(driverId, driverRequest);
		return driverResponse;
	}

	@DeleteMapping("/driver/{driverId}")
	public void deleteDriverById(@PathVariable("driverId") int driverId) {
		driverService.deleteDriverById(driverId);
	}

}
