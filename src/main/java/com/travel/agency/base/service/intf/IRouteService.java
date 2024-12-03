package com.travel.agency.base.service.intf;

import java.util.List;

import com.travel.agency.base.dao.RouteRequest;
import com.travel.agency.base.dto.RouteResponse;

public interface IRouteService {

	List<RouteResponse> getAllRoutes();

	RouteResponse findRouteById(String routeId);

	RouteResponse addRoute(RouteRequest routeRequest);

	void deleteRouteById(String routeId);

	RouteResponse updateRouteById(String routeId, RouteRequest request);

}
