package sisal.services.flightMs.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Where;
import sisal.services.flightMs.domain.base.BaseEntityAudit;
import sisal.services.flightMs.dto.FlightLegDTO;
import sisal.services.flightMs.dto.RouteCreateDTO;
import sisal.services.flightMs.dto.RouteDTO;
import sisal.services.flightMs.dto.RouteUpdateDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Where(clause = "deleted = 0")
@Entity
@Table(name="Route")
public class Route extends BaseEntityAudit {

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "routeId")
    private List<FlightLeg> flightLegList = new ArrayList<>();


    @NotNull
    private Long airportOrigin;

    @NotNull
    private Long airportDestination;

    @NotNull
    private BigDecimal distance;
    public Route fromDTO(RouteCreateDTO routeCreateDTO){
        setAirportDestination(routeCreateDTO.getAirportDestinationId());
        setAirportOrigin(routeCreateDTO.getAirportOriginId());
        setDistance(routeCreateDTO.getDistance());
        return this;
    }
    public Route updateFromDTO(RouteUpdateDTO routeUpdateDTO){
        setAirportDestination(routeUpdateDTO.getAirportDestinationId());
        setAirportOrigin(routeUpdateDTO.getAirportOriginId());
        setDistance(routeUpdateDTO.getDistance());
        return this;
    }
    public Route createInUpdateFromDTO(RouteUpdateDTO routeUpdateDTO){
        setAirportDestination(routeUpdateDTO.getAirportDestinationId());
        setAirportOrigin(routeUpdateDTO.getAirportOriginId());
        setDistance(routeUpdateDTO.getDistance());
        return this;
    }
    public RouteDTO toDTO(){
        RouteDTO dto = new RouteDTO();
        dto.setDistance(getDistance());
        dto.setAirportOriginId(getAirportOrigin());
        dto.setAirportDestinationId(getAirportDestination());
        return dto;
    }






}
