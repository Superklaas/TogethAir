package be.vdab.service;

import be.vdab.domain.Airline;
import be.vdab.domain.Airport;
import be.vdab.domain.Flight;
import be.vdab.domain.TravelClass;
import be.vdab.repository.AirlineRepository;
import be.vdab.repository.AirportRepository;
import be.vdab.repository.FlightRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightService {

    private FlightRepository flightRepository;
    private AirlineRepository airlineRepository;
    private AirportRepository airportRepository;

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getFlightByBasePrice(double price) {
        return flightRepository.getFlightByBasePrice(price);
    }

    public Optional<Flight> getFlightById(int id) {
        return flightRepository.findById(id);
    }

    public List<Flight> searchFlights(String airlineName, String departureName,
                                      String destinationName, LocalDate dateDeparture) {
        Airline airline = airlineRepository.findAirlineByNameContaining(airlineName);
        Airport departure = airportRepository.findAirportByNameContaining(departureName);
        Airport destination = airportRepository.findAirportByNameContaining(destinationName);
        LocalDateTime startOfDay = dateDeparture.atStartOfDay();
        LocalDateTime endOfDay = dateDeparture.atTime(23,59);
        return flightRepository.getFlightByAirlineAndDepartureAndDestinationAndDepartureTimeBetween(
                        airline,departure,destination,startOfDay,endOfDay);
    }



}
