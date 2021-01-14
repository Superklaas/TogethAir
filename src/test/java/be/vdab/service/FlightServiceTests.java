package be.vdab.service;

import be.vdab.domain.Airline;
import be.vdab.domain.Airport;
import be.vdab.domain.Flight;
import be.vdab.repository.AirlineRepository;
import be.vdab.repository.AirportRepository;
import be.vdab.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTests {

    @InjectMocks
    private FlightService flightService;
    @Mock
    private FlightRepository flightRepository;
    @Mock
    private AirlineRepository airlineRepository;
    @Mock
    private AirportRepository airportRepository;

    @Test
    void searchFlights() {
        Airline klm = new Airline("KLM");
        Airport brussels = new Airport("Brussels");
        Airport losAngeles = new Airport("Los Angeles");
        LocalDate dateDeparture = LocalDate.of(2021,1,12);
        Flight flight = new Flight(dateDeparture.atTime(12,45),dateDeparture.atTime(21,45),
                200,brussels,losAngeles,null,null,klm,null,null);
        List<Flight> flights = Collections.singletonList(flight);

        when(airlineRepository.findAirlineByNameContaining("KLM")).thenReturn(klm);
        when(airportRepository.findAirportByNameContaining("Brussels")).thenReturn(brussels);
        when(airportRepository.findAirportByNameContaining("Los Angeles")).thenReturn(losAngeles);
        when(flightRepository.findFlightByAirlineAndDepartureAndDestinationAndDepartureTimeBetween(
                klm,brussels,losAngeles,dateDeparture.atStartOfDay(),dateDeparture.atTime(23,59)
        )).thenReturn(flights);

        assertEquals(flights,flightService.searchFlights(
                "KLM","Brussels","Los Angeles",dateDeparture));

        Mockito.verifyNoMoreInteractions(airlineRepository,airportRepository,flightRepository);
    }

}
