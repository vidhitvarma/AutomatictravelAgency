package com.travel.agency.base.constants;

import com.travel.agency.base.exceptions.InvalidVehicleTypeException;

public enum VehicleType {

	MICRO, MINI, SEDAN, XL, CARRIER;
	
	public static VehicleType toEnum(String inputVehicleType) throws Exception{
		VehicleType type[] = VehicleType.values();
		for(VehicleType vehicle : type) {
			String vehicleInd = vehicle.name();
			if(vehicleInd.equalsIgnoreCase(inputVehicleType)) 
				return vehicle;
		}
		throw new InvalidVehicleTypeException("Vehicle type invalid");
		
	}
}
