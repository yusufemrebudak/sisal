package sisal.services.flightMs.api.response;

import lombok.Getter;
import lombok.Setter;
import sisal.services.flightMs.dto.FlightDTO;
import sisal.services.flightMs.dto.ResultDTO;

import java.util.List;


@Setter
@Getter
public class FlightResponse {
    private List<FlightDTO> flightDTOList;

    public FlightResponse(List<FlightDTO> flightDTOList) {
        this.flightDTOList = flightDTOList;
    }
}
