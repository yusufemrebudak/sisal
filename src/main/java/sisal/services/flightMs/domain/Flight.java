package sisal.services.flightMs.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Where;
import sisal.services.flightMs.domain.base.BaseEntityAudit;
import sisal.services.flightMs.domain.enums.Gender;
import sisal.services.flightMs.dto.*;
import sisal.services.flightMs.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Where(clause = "deleted = 0")
@Entity
@Table(name="Flight")
public class Flight extends BaseEntityAudit {

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "flightId")
    private List<FlightLeg> flightLegList = new ArrayList<>();

    @NotNull
    private String flightCode;

    public Flight fromDTO(FlightCreateDTO flightCreateDTO){
        setFlightCode(RandomGenerator.generate());
        List<FlightLegCreateDTO> flightLegCreateDTOList = flightCreateDTO.getFlightLegCreateDTOList();
        flightLegCreateDTOList.forEach(flightLegCreateDTO -> {
            FlightLeg flightLeg = new FlightLeg().fromDTO(flightLegCreateDTO);
            getFlightLegList().add(flightLeg);
        });

        return this;
    }
    public Flight updateFromDTO(FlightUpdateDTO flightUpdateDTO){
        List<FlightLegUpdateDTO> flightLegUpdateDTOList = flightUpdateDTO.getFlightLegUpdateDTOList();
        getFlightLegList().forEach(flightLeg -> {
            flightLeg.setDeleted(Boolean.TRUE);
            flightLeg.getSeatList().forEach(seat -> seat.setDeleted(Boolean.TRUE));
        });
        List<Long> presentFlightLegIds = getFlightLegList().stream().map(FlightLeg::getId).collect(Collectors.toList());

        // 1,2,3 -> getFlightLegList
        // 1,2,3,4 -> flightLegUpdateDTO
        flightLegUpdateDTOList.forEach(flightLegUpdateDTO -> {
            if(presentFlightLegIds.contains(flightLegUpdateDTO.getId())) {
                for (FlightLeg flightLeg : getFlightLegList()) {
                    if (flightLeg.getId().equals(flightLegUpdateDTO.getId())) {
                        flightLeg.updateFromDTO(flightLegUpdateDTO);
                        flightLeg.setDeleted(Boolean.FALSE);
                        flightLeg.getSeatList().forEach(seat -> seat.setDeleted(Boolean.FALSE));

                    }
                }
            }
            else{
                getFlightLegList().add((new FlightLeg().createInUpdateFromDTO(flightLegUpdateDTO)));
            }

        });

        return this;
    }

    public FlightDTO toDTO(){
        FlightDTO dto = new FlightDTO();
        dto.setFlightLegDTOList(getFlightLegList().stream().map(FlightLeg::toDTO).collect(Collectors.toList()));
        return dto;
    }





}
