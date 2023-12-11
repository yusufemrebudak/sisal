package sisal.services.flightMs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sisal.services.flightMs.domain.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

}
