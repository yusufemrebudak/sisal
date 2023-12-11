package sisal.services.flightMs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sisal.services.flightMs.domain.Flight;
import sisal.services.flightMs.domain.Route;

import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    Flight findOneById(Long id);

}
