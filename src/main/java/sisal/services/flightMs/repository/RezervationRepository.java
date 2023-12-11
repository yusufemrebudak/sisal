package sisal.services.flightMs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sisal.services.flightMs.domain.Rezervation;

@Repository
public interface RezervationRepository extends JpaRepository<Rezervation,Long> {

}
