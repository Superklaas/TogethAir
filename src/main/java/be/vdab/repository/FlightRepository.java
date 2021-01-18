package be.vdab.repository;

import be.vdab.domain.Airline;
import be.vdab.domain.Airport;
import be.vdab.domain.Flight;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer>, SearchFlightRepository {

    List<Flight> getFlightByAirline_NameContaining(String airlineName);

    List<Flight> getFlightByBasePrice(double price);

    List<Flight> getFlightByDeparture_NameContaining(String departureName);

    List<Flight> getFlightByDepartureTimeBetween(LocalDateTime startOfDay,LocalDateTime endOfDay);

    List<Flight> getFlightByDestination_NameContaining(String destinationName);

}
