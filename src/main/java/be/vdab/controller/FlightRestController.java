package be.vdab.controller;

import be.vdab.domain.Flight;
import be.vdab.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    @GetMapping(path = "/searchFlights")
    public List<Flight> searchFlights(
            @RequestParam(value = "dateDeparture",required = false) String dateDeparture,
            @RequestParam(value = "basePrice",required = false) Double basePrice,
            @RequestParam(value = "departureName",required = false) String departureName,
            @RequestParam(value = "destinationName",required = false) String destinationName,
            @RequestParam(value = "airlineName",required = false) String airlineName) {
        return flightService.searchFlights(dateDeparture,basePrice,departureName,destinationName,airlineName);
    }

    @GetMapping(path = "/searchFlights2")
    public List<Flight> searchFlights2(
            @RequestParam(value = "dateDeparture",required = false) String dateDeparture,
            @RequestParam(value = "basePrice",required = false) Double basePrice,
            @RequestParam(value = "departureName",required = false) String departureName,
            @RequestParam(value = "destinationName",required = false) String destinationName,
            @RequestParam(value = "airlineName",required = false) String airlineName) {
        return flightService.searchFlights2(dateDeparture,basePrice,departureName,destinationName,airlineName);
    }


    @PostMapping(path = "/addFlight")
    public ResponseEntity addFlight(@Valid @RequestBody Flight flight, HttpServletRequest request) {
        if(flight.getId() != 0){
            return ResponseEntity.badRequest().build(); // creates statuscode 400 if new flight exists already
        } else {
            flightService.createFlight(flight);
            URI uri = URI.create(request.getRequestURL()+"/"+flight.getId());
            return ResponseEntity.created(uri).build(); // creates statuscode 201 & Location in status description
        }
    }

    @PutMapping(path = "/{id}/updateFlight")
    public ResponseEntity updateFlight(@PathVariable("id") int id, @Valid @RequestBody Flight flight) {
        if(flight.getId() != id) {
            return ResponseEntity.badRequest().build(); // creates statuscode 400 if source not equal to target
        } else {
            flightService.updateFlight(flight);
            return ResponseEntity.ok().build(); // creates statuscode 200
        }
    }

    @PatchMapping(path = "/{id}/updateBasePrice")
    public ResponseEntity updateBasePrice(@PathVariable("id") int id, @RequestBody Flight patchFlight) {
        Flight flight = flightService.getFlightById(id).get();
        if(flight.equals(null)) {
            return ResponseEntity.notFound().build();   // creates statuscode 404 if no flight matches id in url
        } else if((patchFlight.getId() != id) && (patchFlight.getId() != 0)) {
            return ResponseEntity.badRequest().build(); // creates statuscode 400 if patchFlight = other flight in db
        } else {
            flight.setBasePrice(patchFlight.getBasePrice());
            flightService.updateFlight(flight);
            return ResponseEntity.ok().build(); // creates statuscode 200
        }
    }

    @DeleteMapping(path = "/{id}/deleteFlight")
    public ResponseEntity deleteFlight(@PathVariable("id") int id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();  // creates statuscode 204
    }









}
