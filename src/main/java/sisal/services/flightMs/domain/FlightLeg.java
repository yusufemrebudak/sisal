package sisal.services.flightMs.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Where;
import org.springframework.cglib.core.Local;
import sisal.services.flightMs.domain.base.BaseEntityAudit;
import sisal.services.flightMs.domain.enums.SalesStatus;
import sisal.services.flightMs.dto.*;
import sisal.services.flightMs.repository.FlightMsRepositoryLayer;
import sisal.services.flightMs.util.RandomGenerator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Where(clause = "deleted = 0")
@Entity
@Table(name="FlightLeg")
public class FlightLeg extends BaseEntityAudit {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flightId")
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "routeId")
    private Route route;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "flightLegId")
    private List<Rezervation> rezervationList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "flightLegId")
    private List<Seat> seatList = new ArrayList<>();

    @NotNull
    private String flightLegCode;

    private Long airplaneId;

    private LocalDateTime originTime;

    private LocalDateTime arrivalTime;

    private SalesStatus salesStatus;


    public FlightLeg fromDTO(FlightLegCreateDTO flightLegCreateDTO){
        SalesStatus salesStatus1 = flightLegCreateDTO.getSalesStatus();
        setOriginTime(flightLegCreateDTO.getOriginTime());
        setAirplaneId(flightLegCreateDTO.getAirplaneId());
        setArrivalTime(flightLegCreateDTO.getArrivalTime());
        setSalesStatus(flightLegCreateDTO.getSalesStatus());
        setFlightLegCode(RandomGenerator.generate());
        RouteCreateDTO routeCreateDTO = flightLegCreateDTO.getRouteCreateDTO();
        Route route = FlightMsRepositoryLayer.routeRepository().findOneByAirportOriginAndAirportDestination(routeCreateDTO.getAirportOriginId(),routeCreateDTO.getAirportDestinationId());
        if(Objects.isNull(route)){
            setRoute(new Route().fromDTO(flightLegCreateDTO.getRouteCreateDTO()));
        }else{
            setRoute(route);
        }
        // bu kısımda constans ms'e yazılacak api'e airplaneId ile giderek uçakta kaç koltuk olduğu bulunur.
        // default olarak 100 olduğunu varsayarak devam ediyorum.
        int numberOfSeat = 100;
        for(int i=0 ; i<100 ; i++){
            SeatCreateDTO seatCreateDTO = new SeatCreateDTO(salesStatus1,"A"+ String.valueOf(i));
            getSeatList().add(new Seat().fromDTO(seatCreateDTO));
        }
        return this;
    }
    public FlightLeg updateFromDTO(FlightLegUpdateDTO flightLegUpdateDTO){
        SalesStatus salesStatus1 = flightLegUpdateDTO.getSalesStatus();
        setOriginTime(flightLegUpdateDTO.getOriginTime());
        setArrivalTime(flightLegUpdateDTO.getArrivalTime());
        setSalesStatus(flightLegUpdateDTO.getSalesStatus());
        // setFlightLegCode(RandomGenerator.generate());
        RouteUpdateDTO routeUpdateDTO = flightLegUpdateDTO.getRouteUpdateDTO();
        Route route = FlightMsRepositoryLayer.routeRepository().findOneByAirportOriginAndAirportDestination(routeUpdateDTO.getAirportOriginId(),routeUpdateDTO.getAirportDestinationId());
        if(Objects.isNull(route)){
            setRoute(new Route().updateFromDTO(flightLegUpdateDTO.getRouteUpdateDTO()));
        }else{
            setRoute(route);
        }

        // bu kısımda constans ms'e yazılacak api'e airplaneId ile giderek uçakta kaç koltuk olduğu bulunur.
        // default olarak 100 olduğunu varsayarak devam ediyorum.
        if(!getAirplaneId().equals(flightLegUpdateDTO.getAirplaneId())){
            int numberOfSeat = 100;

            getSeatList().forEach(seat -> seat.setDeleted(Boolean.TRUE));
            for(int i = 0 ; i < numberOfSeat ; i++){
                SeatCreateDTO seatCreateDTO = new SeatCreateDTO(salesStatus1,"A"+ String.valueOf(i));
                getSeatList().add(new Seat().fromDTO(seatCreateDTO));
            }
        }
        setAirplaneId(flightLegUpdateDTO.getAirplaneId());


        return this;
    }
    public FlightLeg createInUpdateFromDTO(FlightLegUpdateDTO flightLegUpdateDTO){
        SalesStatus salesStatus1 = flightLegUpdateDTO.getSalesStatus();
        setOriginTime(flightLegUpdateDTO.getOriginTime());
        setAirplaneId(flightLegUpdateDTO.getAirplaneId());
        setArrivalTime(flightLegUpdateDTO.getArrivalTime());
        setSalesStatus(flightLegUpdateDTO.getSalesStatus());
        setFlightLegCode(RandomGenerator.generate());
        RouteUpdateDTO routeUpdateDTO = flightLegUpdateDTO.getRouteUpdateDTO();
        Route route = FlightMsRepositoryLayer.routeRepository().findOneByAirportOriginAndAirportDestination(routeUpdateDTO.getAirportOriginId(),routeUpdateDTO.getAirportDestinationId());

        if(Objects.isNull(route)){
            setRoute(new Route().createInUpdateFromDTO(routeUpdateDTO));
        }else{
            setRoute(route);
        }
        // bu kısımda constans ms'e yazılacak api'e airplaneId ile giderek uçakta kaç koltuk olduğu bulunur.
        // default olarak 100 olduğunu varsayarak devam ediyorum.

        int numberOfSeat = 100;
        for(int i = 0 ; i < numberOfSeat ; i++){
            SeatCreateDTO seatCreateDTO = new SeatCreateDTO(salesStatus1,"A"+ String.valueOf(i));
            getSeatList().add(new Seat().fromDTO(seatCreateDTO));
        }

        return this;
    }
    public FlightLegDTO toDTO(){
        FlightLegDTO dto = new FlightLegDTO();
        dto.setAirplaneId(getAirplaneId());
        dto.setOriginTime(getOriginTime());
        dto.setArrivalTime(getArrivalTime());
        dto.setSalesStatus(getSalesStatus());
        dto.setRouteDTO(getRoute().toDTO());
        dto.setSeatList(getSeatList().stream().map(Seat::toDTO).collect(Collectors.toList()));
        return dto;
    }



}
