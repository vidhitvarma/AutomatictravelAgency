package com.travel.agency.base.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.agency.base.constants.VehicleType;
import com.travel.agency.base.dao.VehicleRequest;
import com.travel.agency.base.dto.VehicleResponse;
import com.travel.agency.base.entity.Driver;
import com.travel.agency.base.entity.Vehicle;
import com.travel.agency.base.exceptions.DriverNotFoundException;
import com.travel.agency.base.exceptions.NoVehiclesFoundException;
import com.travel.agency.base.repository.DriverRepository;
import com.travel.agency.base.repository.VehicleRepository;
import com.travel.agency.base.service.intf.IVehicleService;
import com.travel.agency.base.utility.AgencyUtility;

@Service
public class VehicleService implements IVehicleService{
	
	private VehicleRepository vehicleRepository;
	
	private AgencyUtility agencyUtility;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	public VehicleService(VehicleRepository vehicleRepository,AgencyUtility agencyUtility) {
		this.vehicleRepository = vehicleRepository;
		this.agencyUtility = agencyUtility;
	}
	
	
	@Override
	public VehicleResponse findVehicleById(String vehicleId) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
		if(vehicle.isEmpty()) throw new NoVehiclesFoundException("Vehicle not found with number: " +vehicleId);
		VehicleResponse response = agencyUtility.mapToVehicleResponse(vehicle.get());
		return response;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> listOfVehicles = vehicleRepository.findAll();
		if(listOfVehicles.size()  == 0)
			throw new NoVehiclesFoundException("No vehicles found in data");
//		List<VehicleResponse> responseList = listOfVehicles.stream()
//									.map(vehicle -> agencyUtility.mapToVehicleResponse(vehicle))
//									.collect(Collectors.toList());
		return listOfVehicles;
	}

	@Override
	public VehicleResponse addNewVehicle(VehicleRequest newVehicle) {
		Optional<Driver> driver = driverRepository.findById(newVehicle.getDriverId());
		if(driver.isEmpty()) throw new DriverNotFoundException("Driver not found for id: " +newVehicle.getDriverId());
		Vehicle vehicleToAdd = agencyUtility.mapFromVehicleRequest(newVehicle, driver.get());
		vehicleRepository.save(vehicleToAdd);
		VehicleResponse response = agencyUtility.mapToVehicleResponse(vehicleToAdd);
		return response;
		
	}


	@Override
	public VehicleResponse updateVehicleDetails(String vehicleId, VehicleRequest vehicleRequest) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
		Optional<Driver> driver = driverRepository.findById(vehicleRequest.getDriverId());
		if(driver.isEmpty()) throw new DriverNotFoundException("Driver not found for id: " +vehicleRequest.getDriverId());
		if(vehicle.isEmpty()) throw new NoVehiclesFoundException("Vehicle not found with number: " +vehicleId);
		Vehicle updatedVehicle = agencyUtility.mapFromVehicleRequest(vehicleRequest, vehicle.get(), driver.get());
		vehicleRepository.save(updatedVehicle);
		VehicleResponse response = agencyUtility.mapToVehicleResponse(updatedVehicle);
		return response;
		
	}


	@Override
	public void deleteVehicleById(String vehicleId) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
		if(vehicle.isEmpty()) throw new DriverNotFoundException("Driver not found for id: " +vehicleId);
		vehicleRepository.deleteById(vehicleId);
		
	}

	


	

}
