package sisal.services.flightMs.services;

import sisal.services.flightMs.api.request.FlightCreateRequest;
import sisal.services.flightMs.api.request.FlightUpdateRequest;
import sisal.services.flightMs.api.request.RouteCreateRequest;
import sisal.services.flightMs.dto.ResultDTO;

public interface FlightRezervationCommandService {

    ResultDTO createFlight(FlightCreateRequest request) throws Exception;

    ResultDTO updateFlight(FlightUpdateRequest request) throws Exception;

    ResultDTO deleteFlight(Long flightId) throws Exception;

    ResultDTO createRoute(RouteCreateRequest request) throws Exception;
}
