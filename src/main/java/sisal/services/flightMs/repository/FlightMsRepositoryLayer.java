package sisal.services.flightMs.repository;

import org.springframework.context.ApplicationContext;

public final class FlightMsRepositoryLayer {
    private static ApplicationContext context;
    private FlightMsRepositoryLayer() {

    }


    public static RouteRepository routeRepository() {
        return find(RouteRepository.class);
    }

    public static SeatRepository seatRepository() {
        return find(SeatRepository.class);
    }





    public static <T> T find(Class<T> repositoryClass) {
        return context.getBean(repositoryClass);
    }
    public static void setApplicationContext(ApplicationContext applicationContext) {
        FlightMsRepositoryLayer.context = applicationContext;
    }

}
