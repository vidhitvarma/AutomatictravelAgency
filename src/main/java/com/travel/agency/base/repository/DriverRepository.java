package com.travel.agency.base.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.agency.base.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

	@Query(value =  "Select * from driver where driver_license=:license", nativeQuery = true)
	Optional<Driver> findByDriverLicense(String license);

}
