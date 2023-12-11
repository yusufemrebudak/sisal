package sisal.services.flightMs.dto;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import sisal.services.flightMs.domain.enums.SalesStatus;

@Getter
@Setter
public class SeatDTO {

    @NotNull
    private SalesStatus seatType;

    @NotNull
    private String seatNo;



}
