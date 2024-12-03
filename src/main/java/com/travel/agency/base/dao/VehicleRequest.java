package com.travel.agency.base.dao;

public class VehicleRequest {
	
	private String vehicleNumber;
	
	private String vehicleName;
	
	private int seatingCapacity;
	
	private String vehicleType;
	
	private int fare;
	
	private int driverId;

	public VehicleRequest() {
		super();
	}

	public VehicleRequest(String vehicleNumber, String vehicleName, int seatingCapacity, String vehicleType, int fare,
			int driverId) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.seatingCapacity = seatingCapacity;
		this.vehicleType = vehicleType;
		this.fare = fare;
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

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	@Override
	public String toString() {
		return "VehicleRequest [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", seatingCapacity="
				+ seatingCapacity + ", vehicleType=" + vehicleType + ", fare=" + fare + ", driverId=" + driverId + "]";
	}
	
	
	
}
