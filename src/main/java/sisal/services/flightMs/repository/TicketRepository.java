package sisal.services.flightMs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sisal.services.flightMs.domain.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
