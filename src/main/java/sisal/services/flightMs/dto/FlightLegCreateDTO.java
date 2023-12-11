package sisal.services.flightMs.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import sisal.services.flightMs.domain.enums.SalesStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class FlightLegCreateDTO {


    private RouteCreateDTO routeCreateDTO;

    @NotNull
    private SalesStatus salesStatus;

    @NotNull
    private Long airplaneId;

    @NotNull
    private LocalDateTime originTime;


    private LocalDateTime arrivalTime;





}
