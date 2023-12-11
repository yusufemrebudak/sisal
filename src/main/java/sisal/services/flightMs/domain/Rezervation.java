package sisal.services.flightMs.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Where;
import sisal.services.flightMs.domain.base.BaseEntityAudit;
import sisal.services.flightMs.domain.enums.Gender;

import java.util.UUID;

@Getter
@Setter
@Where(clause = "deleted = 0")
@Entity
@Table(name="Rezervation")
public class Rezervation extends BaseEntityAudit {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketId")
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flightLegId")
    private FlightLeg flightLeg;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"seat\"")
    private Seat seat;

    // @NotNull
    private String rezervationCode;

    // @NotNull
    private Long personId;






}
