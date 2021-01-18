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

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(int id) {
        return flightRepository.findById(id);
    }

    public List<Flight> searchFlights(String dateDepartureString, Double basePrice, String departureName,
                                       String destinationName, String airlineName) {
        List<Flight> resultList = getAllFlights();
        if(dateDepartureString != null) {
            LocalDate dateDeparture = LocalDate.parse(dateDepartureString);
            LocalDateTime startOfDay = dateDeparture.atStartOfDay();
            LocalDateTime endOfDay = dateDeparture.atTime(23,59);
            resultList.retainAll(flightRepository.getFlightByDepartureTimeBetween(startOfDay,endOfDay));
        }
        if(basePrice != null) {
            resultList.retainAll(flightRepository.getFlightByBasePrice(basePrice));
        }
        if(departureName != null) {
            resultList.retainAll(flightRepository.getFlightByDeparture_NameContaining(departureName));
        }
        if(destinationName != null) {
            resultList.retainAll(flightRepository.getFlightByDestination_NameContaining(destinationName));
        }
        if(airlineName != null) {
            resultList.retainAll(flightRepository.getFlightByAirline_NameContaining(airlineName));
        }
        return resultList;
    }

    public List<Flight> searchFlights2(String dateDepartureString, Double basePrice, String departureName,
                                       String destinationName, String airlineName) {
        return flightRepository.searchFlights2(dateDepartureString,basePrice,departureName,destinationName,airlineName);
    }

    public void updateFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }



}
