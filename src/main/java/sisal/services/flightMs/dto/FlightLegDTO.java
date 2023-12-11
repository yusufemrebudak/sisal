package sisal.services.flightMs.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import sisal.services.flightMs.domain.enums.SalesStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FlightLegDTO {
    private List<SeatDTO> seatList;


    private RouteDTO routeDTO;

    @NotNull
    private SalesStatus salesStatus;

    @NotNull
    private Long airplaneId;


    @NotNull
    private LocalDateTime originTime;


    private LocalDateTime arrivalTime;





}
