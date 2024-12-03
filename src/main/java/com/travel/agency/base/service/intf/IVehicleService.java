package com.travel.agency.base.service.intf;

import java.util.List;

import com.travel.agency.base.dao.VehicleRequest;
import com.travel.agency.base.dto.VehicleResponse;
import com.travel.agency.base.entity.Vehicle;

public interface IVehicleService {

	List<Vehicle> getAllVehicles();

	VehicleResponse addNewVehicle(VehicleRequest newVehicle);

	VehicleResponse findVehicleById(String vehicleId);

	VehicleResponse updateVehicleDetails(String vehicleId, VehicleRequest vehicleRequest);

	void deleteVehicleById(String vehicleId);

}
