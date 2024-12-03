package com.travel.agency.base.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.agency.base.dao.RouteRequest;
import com.travel.agency.base.dto.RouteResponse;
import com.travel.agency.base.entity.Route;
import com.travel.agency.base.exceptions.NoRouteFoundException;
import com.travel.agency.base.exceptions.RouteAlreadyPresentException;
import com.travel.agency.base.repository.RouteRepository;
import com.travel.agency.base.service.intf.IRouteService;
import com.travel.agency.base.utility.AgencyUtility;

@Service
public class RouteService implements IRouteService {
	private static final Logger logger = LoggerFactory.getLogger(RouteService.class);

	private RouteRepository routeRepository;

	private AgencyUtility agencyUtility;

	@Autowired
	public RouteService(RouteRepository routeRepository, AgencyUtility agencyUtility) {
		this.routeRepository = routeRepository;
		this.agencyUtility = agencyUtility;
	}

	@Override
	public List<RouteResponse> getAllRoutes() {
		List<Route> listOfRoutes = routeRepository.findAll();
		if (listOfRoutes.size() == 0)
			throw new NoRouteFoundException("No routes found");
		else {
			List<RouteResponse> listOfResponse = listOfRoutes.stream()
					.map(route -> agencyUtility.mapToRouteResponse(route)).collect(Collectors.toList());
			return listOfResponse;
		}
	}

	@Override
	public RouteResponse findRouteById(String routeId) {
		Optional<Route> routeById = routeRepository.findById(routeId);
		if (!routeById.isPresent())
			throw new NoRouteFoundException("Route Not Found for id: " + routeId);
		else {
			RouteResponse routeResponse = agencyUtility.mapToRouteResponse(routeById.get());
			return routeResponse;
		}
	}

	@Override
	public RouteResponse addRoute(RouteRequest routeRequest) {
		String routeCode = routeRequest.getSource().substring(0, 3).toLowerCase() + "-"
				+ routeRequest.getDestination().substring(0, 3).toLowerCase();
		Optional<Route> routeByCode = routeRepository.findRouteByCode(routeCode);
		if (routeByCode.isPresent())
			throw new RouteAlreadyPresentException(
					"Route already exists for " + routeRequest.getSource() + "-" + routeRequest.getDestination());
		else {
			Route newRoute = agencyUtility.mapFromRouteRequest(routeRequest, routeCode);
			logger.info("saving to route repository");
			routeRepository.save(newRoute);
			RouteResponse routeResponse = agencyUtility.mapToRouteResponse(newRoute);
			return routeResponse;
		}
	}

	@Override
	public void deleteRouteById(String routeId) {
		Optional<Route> routeById = routeRepository.findById(routeId);
		if (routeById.isEmpty())
			throw new NoRouteFoundException("Route not found for id: " + routeId);
		else {
			routeRepository.deleteById(routeId);
		}

	}

	@Override
	public RouteResponse updateRouteById(String routeId, RouteRequest request) {
		Optional<Route> routeById = routeRepository.findById(routeId);
		if(routeById.isEmpty())
			throw new NoRouteFoundException("Route not found for id: "+routeId);
		String updatedRouteId = request.getSource().toLowerCase().substring(0, 3) 
				+ "-" + request.getDestination().toLowerCase().subSequence(0, 3);
		Route updatedRoute = routeById.get();
		updatedRoute.setRouteId(updatedRouteId);
		updatedRoute.setSource(request.getSource());
		updatedRoute.setDestination(request.getDestination());
		updatedRoute.setDurationInHours(request.getDurationInHours());
		updatedRoute.setDistance(request.getDistance());
		routeRepository.save(updatedRoute);
		RouteResponse response = agencyUtility.mapToRouteResponse(updatedRoute);
		return response;
		
	}

}
