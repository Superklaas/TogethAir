package be.vdab.service;

import be.vdab.domain.Airline;
import be.vdab.domain.Airport;
import be.vdab.domain.Flight;
import be.vdab.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Test
    void searchFlights() {

        Airline klm = new Airline("KLM");
        Airport brussels = new Airport("Brussels");
        Airport losAngeles = new Airport("Los Angeles");
        double basePrice = 200;
        LocalDate dateDeparture = LocalDate.of(2021,1,12);
        LocalDateTime startOfDay = dateDeparture.atStartOfDay();
        LocalDateTime endOfDay = dateDeparture.atTime(23,59);

        Flight flight = new Flight(dateDeparture.atTime(12,45),dateDeparture.atTime(21,45),
                200,brussels,losAngeles,null,null,klm,null,null);
        List<Flight> flights = Collections.singletonList(flight);

        when(flightRepository.findAll()).thenReturn(flights);
        when(flightRepository.getFlightByDepartureTimeBetween(startOfDay,endOfDay)).thenReturn(flights);
        when(flightRepository.getFlightByBasePrice(basePrice)).thenReturn(flights);
        when(flightRepository.getFlightByDeparture_NameContaining("Brussels")).thenReturn(flights);
        when(flightRepository.getFlightByDestination_NameContaining("Los Angeles")).thenReturn(flights);
        when(flightRepository.getFlightByAirline_NameContaining("KLM")).thenReturn(flights);

        assertEquals(flights,flightService.searchFlightsComplicated("2021-01-12", 200.0,
                "Brussels","Los Angeles", "KLM"));

        Mockito.verifyNoMoreInteractions(flightRepository);

    }

}
