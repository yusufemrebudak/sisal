package sisal.services.flightMs.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class RouteCreateDTO {

    @NotNull
    private Long airportOriginId;

    @NotNull
    private Long airportDestinationId;
    @NotNull
    private BigDecimal distance;



}
