package sisal.services.flightMs.api.constant;

import org.springframework.http.MediaType;

public final class ApiEndpoints {
	public static final String RESPONSE_CONTENTTYPE = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";

	public static final String API_BASE_URL = "/api";

	public static  final  String FLIGHT_REZERVATION = API_BASE_URL + "/flightRezervation";

	public static final String FLIGHT_REZERVATION_EXTERNAL = API_BASE_URL + "/flightRezervationExternal";

	private ApiEndpoints() {

	}
}
