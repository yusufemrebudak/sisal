package sisal.services.flightMs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sisal.services.flightMs.domain.Route;

import java.util.UUID;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    Route findOneByAirportOriginAndAirportDestination(Long airportOrigin, Long airportDestination);

}
