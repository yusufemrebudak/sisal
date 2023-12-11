package sisal.services.flightMs.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sisal.services.flightMs.api.request.FlightCreateRequest;
import sisal.services.flightMs.api.request.FlightUpdateRequest;
import sisal.services.flightMs.api.request.RouteCreateRequest;
import sisal.services.flightMs.domain.*;
import sisal.services.flightMs.dto.FlightCreateDTO;
import sisal.services.flightMs.dto.FlightUpdateDTO;
import sisal.services.flightMs.dto.ResultDTO;
import sisal.services.flightMs.repository.FlightRepository;
import sisal.services.flightMs.repository.RouteRepository;
import sisal.services.flightMs.repository.TicketRepository;
import sisal.services.flightMs.services.FlightRezervationCommandService;

import java.util.Objects;

@Service
@Transactional
public class FlightRezervationCommandServiceImpl  implements FlightRezervationCommandService {
    private final ResultDTO successDTO = ResultDTO.builder().resultCode("S").resultMsg("Success").build();
    private final ResultDTO failDTO = ResultDTO.builder().resultCode("E").resultMsg("Error").build();

    private final TicketRepository ticketRepository;

    private final RouteRepository routeRepository;

    private final FlightRepository flightRepository;


    @Autowired
    public FlightRezervationCommandServiceImpl( TicketRepository ticketRepository,RouteRepository routeRepository,FlightRepository flightRepository) {
        this.ticketRepository=ticketRepository;
        this.routeRepository=routeRepository;
        this.flightRepository=flightRepository;
    }



    @Override
    public ResultDTO createFlight(FlightCreateRequest request) throws Exception {

        FlightCreateDTO flightCreateDTO = request.getFlightCreateDTO();
        if(flightCreateDTO.getFlightLegCreateDTOList().isEmpty()){
            throw new Exception("Request shouldn't be empty.");
        }
        Flight flight = new Flight().fromDTO(flightCreateDTO);
        flightRepository.save(flight);

        return successDTO;
    }
    @Override
    public ResultDTO updateFlight(FlightUpdateRequest request) throws Exception {

        FlightUpdateDTO flightUpdateDTO = request.getFlightUpdateDTO();
        if(Objects.isNull(flightUpdateDTO.getId())){
            throw new Exception("Id shouldn't be empty.");
        }
        Flight flight = flightRepository.findOneById(flightUpdateDTO.getId());
        if(Objects.isNull(flight)){
            throw new Exception("Flight couldn't find.");
        }
        flight.updateFromDTO(flightUpdateDTO);
        flightRepository.save(flight);

        return successDTO;
    }
    @Override
    public ResultDTO deleteFlight(Long flightId) throws Exception {
        if(Objects.isNull(flightId)){
            throw new Exception("FlightId shouldn't be empty.");
        }
        Flight flight = flightRepository.findOneById(flightId);
        if(Objects.isNull(flight)){
            throw new Exception("Flight couldn't find.");
        }

        flight.setDeleted(Boolean.TRUE);
        if(!flight.getFlightLegList().isEmpty()){
            flight.getFlightLegList().forEach(flightLeg -> {
                flightLeg.setDeleted(Boolean.TRUE);
                flightLeg.getSeatList().forEach(seat -> seat.setDeleted(Boolean.TRUE));
            });
        }
        flightRepository.save(flight);
        return successDTO;
    }

    @Override
    public ResultDTO createRoute(RouteCreateRequest request) throws Exception {
        if(Objects.nonNull(request.getRouteCreateDTO())){
            throw new Exception("Request shouldn't be empty.");
        }
        Route route = new Route().fromDTO(request.getRouteCreateDTO());
        routeRepository.save(route);
        return successDTO;
    }




}
