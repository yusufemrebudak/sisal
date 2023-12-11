package sisal.services.flightMs.api.constant;

public final class ApiGroups {

    private ApiGroups() {

    }

    public static final class FlightRezervation {
        public static final String NAME = "fligtRezervation-api";
        public static final String TITLE = "fligtRezervationApi";
        public static final String DESCRIPTION = "fligtRezervation Api";
        public static final String PATHS = "/api/fligtRezervation/**";

        private FlightRezervation() {

        }
    }


    public static final class External {
        public static final String NAME = "fligtRezervation-external-api";
        public static final String TITLE = "fligtRezervationExternalApi";
        public static final String DESCRIPTION = "FligtRezervation External Api";
        public static final String PATHS = "/api/fligtRezervationExternal/**";

        private External() {

        }
    }

}