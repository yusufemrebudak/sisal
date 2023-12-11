package sisal.services.flightMs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import sisal.services.flightMs.repository.FlightMsRepositoryLayer;

@SpringBootApplication
public class FlightMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightMsApplication.class, args);
	}

}
