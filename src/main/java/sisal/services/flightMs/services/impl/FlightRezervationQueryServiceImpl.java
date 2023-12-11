package sisal.services.flightMs.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sisal.services.flightMs.domain.Flight;
import sisal.services.flightMs.dto.FlightCreateDTO;
import sisal.services.flightMs.dto.FlightDTO;
import sisal.services.flightMs.repository.FlightLegRepository;
import sisal.services.flightMs.repository.FlightRepository;
import sisal.services.flightMs.services.FlightRezervationQueryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightRezervationQueryServiceImpl implements FlightRezervationQueryService {
    private final FlightLegRepository flightLegRepository;

    @Autowired
    public FlightRezervationQueryServiceImpl( FlightLegRepository flightLegRepository) {
        this.flightLegRepository=flightLegRepository;
    }

    @Override
    public List<FlightDTO> getByOriginToArrival(Long originId, Long arrivalId) throws Exception {

        List<Flight> flightList = flightLegRepository.findFlightFromOriginToArrival(originId,arrivalId);
        return  flightList.stream().map(Flight::toDTO).collect(Collectors.toList());

    }
}
