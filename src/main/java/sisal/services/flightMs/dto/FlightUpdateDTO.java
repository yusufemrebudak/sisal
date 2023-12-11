package sisal.services.flightMs.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlightUpdateDTO {
    private Long id;
    private List<FlightLegUpdateDTO> flightLegUpdateDTOList;






}
