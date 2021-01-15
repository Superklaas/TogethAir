package be.vdab.controller;

import be.vdab.domain.Flight;
import be.vdab.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/flights")
@AllArgsConstructor
public class FlightRestController {

    private FlightService flightService;

    @GetMapping(path = "{id}")
    public Optional<Flight> getFlightById(@PathVariable("id") int id) {
        return flightService.getFlightById(id);
    }


}
