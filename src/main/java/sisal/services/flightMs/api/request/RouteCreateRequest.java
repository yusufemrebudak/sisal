package sisal.services.flightMs.api.request;

import lombok.Getter;
import lombok.Setter;
import sisal.services.flightMs.dto.FlightCreateDTO;
import sisal.services.flightMs.dto.RouteCreateDTO;

import java.util.List;

@Getter
@Setter
public class RouteCreateRequest {
    private RouteCreateDTO routeCreateDTO;

}
