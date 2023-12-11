package sisal.services.flightMs.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Getter
@Setter
public class RouteUpdateDTO {

    @NotNull
    private Long airportOriginId;

    @NotNull
    private Long airportDestinationId;
    @NotNull
    private BigDecimal distance;



}
