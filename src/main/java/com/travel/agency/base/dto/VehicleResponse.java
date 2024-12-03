package com.travel.agency.base.dto;

import com.travel.agency.base.constants.VehicleType;
import com.travel.agency.base.entity.Driver;

public class VehicleResponse {

	private String vehicleNumber;

	private String vehicleName;
	
	private int seatingCapacity;

	private VehicleType vehicleType;

	private int farePerKilometer;
	
	private Driver driverId;	
	

	public VehicleResponse() {}


	public VehicleResponse(String vehicleNumber, String vehicleName, int seatingCapacity, VehicleType vehicleType,
			int farePerKilometer, Driver driverId) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.seatingCapacity = seatingCapacity;
		this.vehicleType = vehicleType;
		this.farePerKilometer = farePerKilometer;
		this.driverId = driverId;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getVehicleName() {
		return vehicleName;
	}


	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}


	public int getSeatingCapacity() {
		return seatingCapacity;
	}


	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}


	public VehicleType getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}


	public int getFarePerKilometer() {
		return farePerKilometer;
	}


	public void setFarePerKilometer(int farePerKilometer) {
		this.farePerKilometer = farePerKilometer;
	}


	public Driver getDriverId() {
		return driverId;
	}


	public void setDriverId(Driver driverId) {
		this.driverId = driverId;
	}


	@Override
	public String toString() {
		return "VehicleResponse [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", seatingCapacity="
				+ seatingCapacity + ", vehicleType=" + vehicleType + ", farePerKilometer=" + farePerKilometer
				+ ", driverId=" + driverId + "]";
	}
	
	

}
