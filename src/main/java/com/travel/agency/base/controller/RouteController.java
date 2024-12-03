package com.travel.agency.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.agency.base.dao.RouteRequest;
import com.travel.agency.base.dto.RouteResponse;
import com.travel.agency.base.service.intf.IRouteService;

@RestController
@RequestMapping("/api")
public class RouteController {
	
	private IRouteService routeService;
	
	@Autowired
	public RouteController(IRouteService routeService) {
		this.routeService = routeService;
	}

//	Get Route
	@GetMapping("/route/{routeId}")
	public RouteResponse getRoute(@PathVariable("routeId") String routeId) {
		RouteResponse routeResponse = routeService.findRouteById(routeId);
		return routeResponse;
	}
	
//	Get List of Routes
	@GetMapping("/route")
	public List<RouteResponse> getAllRoutes(){
		List<RouteResponse> response = routeService.getAllRoutes();
		return response;
	}

//	Add route to database
	@PostMapping("/route")
	public RouteResponse addNewRoute(@RequestBody RouteRequest routeRequest) {
		RouteResponse routeResponse = routeService.addRoute(routeRequest);
		return routeResponse;
	}
	
//	Update route
	@PutMapping("/route/{routeId}")
	public RouteResponse updateRouteById(@PathVariable("routeId") String routeId, @RequestBody RouteRequest request) {
		RouteResponse response = routeService.updateRouteById(routeId, request);
		return response;
	}
	
//	Delete route
	@DeleteMapping("/route/{routeId}")
	public void deleteRouteById(@PathVariable("routeId") String routeId) {
		routeService.deleteRouteById(routeId);
	}

}
