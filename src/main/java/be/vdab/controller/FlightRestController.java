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

    @GetMapping(path = "")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping(path = "{id}")
    public Optional<Flight> getFlightById(@PathVariable("id") int id) {
        return flightService.getFlightById(id);
    }

    @GetMapping(params = {"basePrice"})
    public List<Flight> getFlightByBasePrice(@RequestParam("basePrice") double price) {
        return flightService.getFlightByBasePrice(price);
    }

//    @GetMapping(params = {"airlineName","departureName","destinationName","dateDeparture"})
//    public List<Flight> searchFlights(
//            @RequestParam(value = "airlineName",required = false) String airlineName,
//            @RequestParam(value = "departureName",required = false)String departureName,
//            @RequestParam(value = "destinationName",required = false) String destinationName,
//            @RequestParam(value = "dateDeparture",required = false)LocalDate dateDeparture) {
//        return flightService.searchFlights(airlineName,departureName,destinationName,dateDeparture);
//    }


}
