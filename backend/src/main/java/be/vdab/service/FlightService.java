package be.vdab.service;

import be.vdab.domain.Flight;
import be.vdab.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightService {

    private FlightRepository flightRepository;

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(int id) {
        return flightRepository.findById(id);
    }

    public List<Flight> searchFlights(String date, Double price, String departure, String destination, String airline) {
        return flightRepository.searchFlights(date,price,departure,destination,airline);
    }

    public List<Flight> searchFlightsComplicated(String date, Double price, String departure,
                                                 String destination, String airline) {
        List<Flight> resultList = getAllFlights();
        if(date != null) {
            LocalDate dateDeparture = LocalDate.parse(date);
            LocalDateTime startOfDay = dateDeparture.atStartOfDay();
            LocalDateTime endOfDay = dateDeparture.atTime(23,59);
            resultList.retainAll(flightRepository.getFlightByDepartureTimeBetween(startOfDay,endOfDay));
        }
        if(price != null) {
            resultList.retainAll(flightRepository.getFlightByBasePrice(price));
        }
        if(departure != null) {
            resultList.retainAll(flightRepository.getFlightByDeparture_NameContaining(departure));
        }
        if(destination != null) {
            resultList.retainAll(flightRepository.getFlightByDestination_NameContaining(destination));
        }
        if(airline != null) {
            resultList.retainAll(flightRepository.getFlightByAirline_NameContaining(airline));
        }
        return resultList;
    }

    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }



}
