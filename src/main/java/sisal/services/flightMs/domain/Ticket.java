package sisal.services.flightMs.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Where;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import sisal.services.flightMs.domain.base.BaseEntityAudit;
import sisal.services.flightMs.domain.enums.Gender;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Where(clause = "deleted = 0")
@Entity
@Table(name="Ticket")
public class Ticket extends BaseEntityAudit {

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "ticketId")
    private List<Rezervation> rezervationList = new ArrayList<>();

    @NotNull
    private String name;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private Gender gender;

    @NotNull
    private String passengerPnrCode;




}
