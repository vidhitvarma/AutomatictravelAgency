package com.travel.agency.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.agency.base.dao.VehicleRequest;
import com.travel.agency.base.dto.VehicleResponse;
import com.travel.agency.base.entity.Vehicle;
import com.travel.agency.base.service.intf.IVehicleService;

@RestController
public class VehicleController {

	private IVehicleService vehicleService;

	@Autowired
	public VehicleController(IVehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@GetMapping(value = "/vehicle")
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> listOfVehicles = vehicleService.getAllVehicles();
		return listOfVehicles;
	}

	@GetMapping("/vehicle/{vehicleId}")
	public VehicleResponse getVehicleById(@PathVariable String vehicleId) {
		return vehicleService.findVehicleById(vehicleId);
	}

	@PostMapping("/vehicle")
	public VehicleResponse addNewVehicle(@RequestBody VehicleRequest newVehicle) {
		VehicleResponse vehicle = vehicleService.addNewVehicle(newVehicle);
		return vehicle;

	}

	@PutMapping("/vehicle/{vehicleId}")
	public VehicleResponse updateVehicle(@PathVariable("vehicleId") String vehicleId,
			@RequestBody VehicleRequest vehicleRequest) {
		VehicleResponse response = vehicleService.updateVehicleDetails(vehicleId, vehicleRequest);
		return response;
	}

	@DeleteMapping("/vehicle/{vehicleId}")
	public void deleteVehicle(@PathVariable String vehicleId) {
		vehicleService.deleteVehicleById(vehicleId);
	}

}
