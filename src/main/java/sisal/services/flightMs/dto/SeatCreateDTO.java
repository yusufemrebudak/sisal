package sisal.services.flightMs.dto;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import sisal.services.flightMs.domain.enums.SalesStatus;

import java.math.BigDecimal;

@Getter
@Setter
public class SeatCreateDTO {
    public SeatCreateDTO(SalesStatus seatType, String seatNo) {
        this.seatType = seatType;
        this.seatNo = seatNo;
    }

    @NotNull
    private SalesStatus seatType;

    @NotNull
    private String seatNo;



}
