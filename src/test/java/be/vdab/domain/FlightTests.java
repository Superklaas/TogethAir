package be.vdab.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.*;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTests {

    private Validator validator;
    private Flight flight;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;

    @BeforeEach
    void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        departureTime = LocalDateTime.of(2021,1,9,12,15);
        arrivalTime = LocalDateTime.of(2021,1,9,14,15);
    }

    @Test
    void basePrice_CorrectValue() {
        flight = new Flight(departureTime,arrivalTime,12345.12);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertTrue(violations.isEmpty());
        assertEquals(12345.12,flight.getBasePrice());
    }

    @Test
    void basePrice_TooManyDigitsInFraction() {
        flight = new Flight(departureTime,arrivalTime,12345.123);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty());
        assertEquals("basePrice can contain 5 digits in integer and 2 digits in fraction",
                violations.iterator().next().getMessage());
    }

    @Test
    void basePrice_TooManyDigitsInInteger() {
        flight = new Flight(departureTime,arrivalTime,123456.12);
        Set<ConstraintViolation<Flight>> violations = validator.validate(flight);
        assertFalse(violations.isEmpty());
        assertEquals("basePrice can contain 5 digits in integer and 2 digits in fraction",
                violations.iterator().next().getMessage());
    }

}
