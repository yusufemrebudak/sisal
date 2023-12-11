package sisal.services.flightMs.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import sisal.services.flightMs.domain.enums.SalesStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FlightDTO {

    private List<FlightLegDTO> flightLegDTOList;







}
