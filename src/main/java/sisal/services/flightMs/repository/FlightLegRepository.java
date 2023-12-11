package sisal.services.flightMs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sisal.services.flightMs.domain.Flight;
import sisal.services.flightMs.domain.FlightLeg;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightLegRepository extends JpaRepository<FlightLeg,Long> {

/*
    @Query("SELECT DISTINCT fl.flight " +
            "FROM FlightLeg fl " +
            "JOIN fl.route r " +
            "WHERE r.airportOrigin = :airportOrigin AND r.airportDestination = :airportDestination  AND fl.salesStatus = 'IN_SALE' ")
    List<Flight> findFlightFromOriginToArrival(@Param("airportOrigin") Long airportOrigin, @Param("airportDestination") Long airportDestination);


 */
@Query("SELECT DISTINCT fl.flight " +
        "FROM FlightLeg fl " +
        "JOIN fl.route r " +
        "WHERE r.airportOrigin = :airportOrigin AND r.airportDestination = :airportDestination  ")
List<Flight> findFlightFromOriginToArrival(@Param("airportOrigin") Long airportOrigin, @Param("airportDestination") Long airportDestination);
}
