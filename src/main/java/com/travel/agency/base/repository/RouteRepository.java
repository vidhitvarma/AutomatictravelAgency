package com.travel.agency.base.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travel.agency.base.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, String>{

	@Query(value = "SELECT * FROM ROUTE WHERE route_id=:routeCode", nativeQuery = true)
	Optional<Route> findRouteByCode(String routeCode);

}
