package sisal.services.flightMs.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sisal.services.flightMs.api.constant.ApiEndpoints;
import sisal.services.flightMs.api.constant.ApiGroups;
import sisal.services.flightMs.api.request.FlightCreateRequest;
import sisal.services.flightMs.api.request.FlightUpdateRequest;
import sisal.services.flightMs.api.request.RouteCreateRequest;
import sisal.services.flightMs.api.response.FlightResponse;
import sisal.services.flightMs.api.response.ResultResponse;
import sisal.services.flightMs.services.FlightRezervationCommandService;
import sisal.services.flightMs.services.FlightRezervationQueryService;

@RestController
@RequestMapping(value = ApiEndpoints.FLIGHT_REZERVATION, produces = ApiEndpoints.RESPONSE_CONTENTTYPE, consumes = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Tag(name = ApiGroups.FlightRezervation.NAME)
@RequiredArgsConstructor
public class FlightRezervationApiController {
    private final FlightRezervationCommandService flightRezervationCommandService;
    private final FlightRezervationQueryService flightRezervationQueryService;


    @GetMapping(value = "/flight/getByOriginToArrival", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "", description  = "get flight based on city")
    public FlightResponse getByOriginToArrival(@RequestParam("originId") Long originId,
                                               @RequestParam("arrivalId") Long arrivalId) throws Exception {
        return new FlightResponse( flightRezervationQueryService.getByOriginToArrival(originId,arrivalId));
    }

    @PostMapping(value = "/route/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "", description  = "Create route")
    public ResultResponse createRoute(@RequestBody RouteCreateRequest request) throws Exception {
        return new ResultResponse( flightRezervationCommandService.createRoute(request));
    }

    @PostMapping(value = "/flight/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "", description  = "Create flight")
    public ResultResponse createFlight(@RequestBody FlightCreateRequest request) throws Exception {
        return new ResultResponse( flightRezervationCommandService.createFlight(request));
    }
    @PutMapping(value = "/flight/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "", description  = "Create flight")
    public ResultResponse updateFlight(@RequestBody FlightUpdateRequest request) throws Exception {
        return new ResultResponse( flightRezervationCommandService.updateFlight(request));
    }
    @DeleteMapping(value = "/flight/delete", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary  = "", description  = "delete flight")
    public ResultResponse deleteFlight(@RequestParam("flightId") Long flightId) throws Exception {
        return new ResultResponse( flightRezervationCommandService.deleteFlight(flightId));
    }

}
