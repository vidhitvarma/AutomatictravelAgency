package com.travel.agency.base.entity;

import com.travel.agency.base.constants.VehicleType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@Column(name = "vehicle_number")
	private String vehicleNumber;

	@Column(name = "vehicle_name")
	private String vehicleName;
		
	@Column(name = "seating_capacity")
	private int seatingCapacity;

	@Column(name = "vehicle_type")
	private VehicleType vehicleType;

	@Column(name = "fare_per_kilometer")
	private int farePerKilometer;


	@OneToOne
	@JoinColumn(name="driverId", referencedColumnName = "driver_id")
	private Driver driverId;


	public Vehicle() {
		super();
	}


	public Vehicle(String vehicleNumber, String vehicleName, int seatingCapacity, VehicleType vehicleType,
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
		return "Vehicle [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", seatingCapacity="
				+ seatingCapacity + ", vehicleType=" + vehicleType + ", farePerKilometer=" + farePerKilometer
				+ ", driverId=" + driverId + "]";
	}
	
	
	

}
