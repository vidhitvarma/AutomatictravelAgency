package com.travel.agency.base.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.agency.base.entity.Driver;
import com.travel.agency.base.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	@Query(value = "SELECT * FROM driver  where driver_id=:id", nativeQuery = true)
	Optional<Driver> findDriverById(int id);

}
