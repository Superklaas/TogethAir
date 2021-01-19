package be.vdab.repository;

import be.vdab.domain.Flight;

import java.util.List;

public interface SearchFlightRepository {

    List<Flight> searchFlights(String dateDepartureString, Double basePrice, String departureName,
                               String destinationName, String airlineName);

}
