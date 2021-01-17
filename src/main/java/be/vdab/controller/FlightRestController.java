package be.vdab.controller;

import be.vdab.domain.Flight;
import be.vdab.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/flights")
@AllArgsConstructor
public class FlightRestController {

    private FlightService flightService;

    @GetMapping(path = "/getAllFlights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping(path = "/getFlightById/{id}")
    public Optional<Flight> getFlightById(@PathVariable("id") int id) {
        return flightService.getFlightById(id);
    }

    @GetMapping(path = "/getFlightByBasePrice",params = {"basePrice"})
    public List<Flight> getFlightByBasePrice(@RequestParam("basePrice") double price) {
        return flightService.getFlightByBasePrice(price);
    }

    @GetMapping(
            path = "/searchFlights",
            params = {"airlineName","departureName","destinationName","dateDeparture"})
    public List<Flight> searchFlights(
            @RequestParam(value = "airlineName",required = false,defaultValue = "Brussels Airlines") String airlineName,
            @RequestParam(value = "departureName",required = false,defaultValue = "Brussels") String departureName,
            @RequestParam(value = "destinationName",required = false,defaultValue = "Los Angeles") String destinationName,
            @RequestParam(value = "dateDeparture",required = false,defaultValue = "2021-01-09") String dateString) {
        LocalDate dateDeparture = LocalDate.parse(dateString);
        return flightService.searchFlights(airlineName,departureName,destinationName,dateDeparture);
    }

    @PostMapping(path = "/addFlight")
    public ResponseEntity addFlight(@RequestBody Flight flight, HttpServletRequest request) {
        if(flight.getId() != 0){
            return ResponseEntity.badRequest().build(); // creates statuscode 400
        } else {
            flightService.createFlight(flight);
            URI uri = URI.create(request.getRequestURL()+"/"+flight.getId());
            return ResponseEntity.created(uri).build(); // creates statuscode 201
        }
    }

    @PutMapping(path = "/updateFlight/{id}")
    public ResponseEntity updateFlight(@PathVariable("id") int id, @RequestBody Flight flight) {
        if(flight.getId() != id) {
            return ResponseEntity.badRequest().build(); // creates statuscode 400
        } else {
            flightService.updateFlight(flight);
            return ResponseEntity.ok().build(); // creates statuscode 200
        }
    }

    @PatchMapping(path = "/updateBasePrice/{id}")
    public ResponseEntity updateBasePrice(@PathVariable("id") int id, @RequestBody Flight patchFlight) {
        Flight flight = flightService.getFlightById(id).get();
        if(flight.equals(null)) {
            return ResponseEntity.notFound().build();   // creates statuscode 404
        } else if((patchFlight.getId() != id) && (patchFlight.getId() != 0)) {
            return ResponseEntity.badRequest().build(); // creates statuscode 400
        } else {
            flight.setBasePrice(patchFlight.getBasePrice());
            flightService.updateFlight(flight);
            return ResponseEntity.ok().build(); // creates statuscode 200
        }
    }







}
