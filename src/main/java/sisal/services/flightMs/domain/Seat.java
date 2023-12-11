package sisal.services.flightMs.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Where;
import sisal.services.flightMs.domain.base.BaseEntityAudit;
import sisal.services.flightMs.domain.enums.SalesStatus;
import sisal.services.flightMs.dto.FlightLegDTO;
import sisal.services.flightMs.dto.RouteCreateDTO;
import sisal.services.flightMs.dto.SeatCreateDTO;
import sisal.services.flightMs.dto.SeatDTO;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Where(clause = "deleted = 0")
@Entity
@Table(name="Seat")
public class Seat extends BaseEntityAudit {

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "flightLegId")
    private FlightLeg flightLeg;


    @NotNull
    private SalesStatus seatType;

    @NotNull
    private String seatNo;



    public Seat fromDTO(SeatCreateDTO seatCreateDTO){
        setSeatType(seatCreateDTO.getSeatType());
        setSeatNo(seatCreateDTO.getSeatNo());
        return this;
    }
    public SeatDTO toDTO(){
        SeatDTO dto = new SeatDTO();
        dto.setSeatNo(getSeatNo());
        dto.setSeatType(getSeatType());
        return dto;
    }






}
