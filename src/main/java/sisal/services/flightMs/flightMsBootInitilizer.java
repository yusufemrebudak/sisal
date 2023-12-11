package sisal.services.flightMs;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sisal.services.flightMs.repository.FlightMsRepositoryLayer;

@Component
public class flightMsBootInitilizer implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        FlightMsRepositoryLayer.setApplicationContext(event.getApplicationContext());

    }
}
