package be.vdab.repository;

import be.vdab.TogethAirApplication;
import be.vdab.domain.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TogethAirApplication.class)
public class FlightRepositoryTests {

    @Autowired
    FlightRepository flightRepository;

    @Test
    void findById_CorrectId_CorrectBasePrice() {
        Flight flight = flightRepository.findById(1).get();
        assertEquals(200,flight.getBasePrice());
    }

    @Test
    void findAll_ResultListHasCorrectSize() {
        List<Flight> flights = flightRepository.findAll();
        assertEquals(1,flights.size());
    }

}
