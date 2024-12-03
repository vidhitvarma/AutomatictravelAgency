package com.travel.agency.base.loader;

import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.travel.agency.base.constants.VehicleType;
import com.travel.agency.base.entity.Booking;
import com.travel.agency.base.entity.Driver;
import com.travel.agency.base.entity.Route;
import com.travel.agency.base.entity.Vehicle;
import com.travel.agency.base.repository.BookingRepository;
import com.travel.agency.base.repository.DriverRepository;
import com.travel.agency.base.repository.RouteRepository;
import com.travel.agency.base.repository.VehicleRepository;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class DataBootLoader {
	
	private static Logger logger = LoggerFactory.getLogger(DataBootLoader.class);

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(new Info().title("Automatic Travel Agency base")
				.description("This is a case study for refreshment").version("1.0"));
	}

	@Bean
	public CommandLineRunner driverDataLoader(DriverRepository driverRepository, VehicleRepository vehicleRepository) {
		return args -> {
			logger.warn("inserting driver info");
			Driver driver1 = new Driver("Driver1","Mumbai","1111111111","ABCDXZ1234F");
			Driver driver2 = new Driver("Driver2","Pune","2222222222","DWCDXZ1276K");
			Driver driver3 = new Driver("Driver3","Bangalore","3333333333","YIUHJZ1312B");
			Driver driver4 = new Driver("Driver4","Hyderabad","4444444444","UIWNXZ1234L");
			Driver driver5 = new Driver("Driver5","Kolkata","5555555555","PLKCOZ1274D");
			driverRepository.saveAll(Arrays.asList(driver1, driver2, driver3, driver4, driver5));
			logger.warn("Driver insert ends");
			logger.warn("Inserting vehicle info");
			Vehicle vehicle1 = new Vehicle("MH47UU9888","Suzuki-WagonR",5, VehicleType.MINI,7, driver1);
			Vehicle vehicle2 = new Vehicle("UP20IK1922","Suzuki-Ertiga",7, VehicleType.XL,13, driver2);
			Vehicle vehicle3 = new Vehicle("MP20WJ2182","Tata-Tiago",5, VehicleType.MINI,8, driver3);
			Vehicle vehicle4 = new Vehicle("GJ81CC0218","Honda-City",5, VehicleType.SEDAN,11, driver4);
			Vehicle vehicle5 = new Vehicle("MH12ZA9201","Kia-Carnival",9, VehicleType.MINI,20 , driver5);
			vehicleRepository.saveAll(Arrays.asList(vehicle1,vehicle2,vehicle3,vehicle4,vehicle5)); 
			logger.warn("Vehicle insert ends");
		};
	}
	
	@Bean
	public CommandLineRunner routeDataLoader(RouteRepository routeRepository) {
		return args -> {
			logger.warn("Inserting route info");
			Route route1 = new Route("del-mum","Delhi","Mumbai",1826.00, 36);
			Route route2 = new Route("mum-nag","Mumbai","Nagpur",716.00, 12);
			Route route3 = new Route("mum-jai","Mumbai","Jaipur",1106.00, 26);
			Route route4 = new Route("che-del","Chennai","Delhi",2926.00, 70);
			Route route5 = new Route("mum-ahe","Mumbai","Ahemdabad",521.00, 8);
			routeRepository.saveAll(Arrays.asList(route1,route2,route3,route4,route5));
			logger.info("inserting route ends");
		};
	}
	
	@Bean
	public CommandLineRunner bookingDataLoader(BookingRepository bookingRepository) {
		return args -> {
			logger.warn("Inserting booking info");
			Booking booking1 = new Booking(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 12, 1), "Mumbai", "Lonavala", "Borivali" , "Lonavala", 5);
			Booking booking2 = new Booking(LocalDate.of(2024,9, 1), LocalDate.of(2024, 10, 11), "Delhi", "Kashmir", "Delhi Gate" , "Kashmir center", 2);
			Booking booking3 = new Booking(LocalDate.of(2024, 11, 4), LocalDate.of(2024, 12, 11), "Mumbai", "Badrinath", "Borivali" , "Temple", 7);
			Booking booking4 = new Booking(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 2, 1), "Kolkata", "Mumbai", "Kolkata" , "Mumbai", 4);
			bookingRepository.saveAll(Arrays.asList(booking1,booking2, booking3,booking4));
			logger.warn("Inserting booking ends");
		};
	}
	
	

}
