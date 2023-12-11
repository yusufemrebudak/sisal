package sisal.services.flightMs.services;

import sisal.services.flightMs.dto.FlightDTO;

import java.util.List;

public interface FlightRezervationQueryService {
    List<FlightDTO> getByOriginToArrival(Long originId, Long arrivalId) throws Exception;
}
