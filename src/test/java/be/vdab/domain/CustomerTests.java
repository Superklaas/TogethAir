package be.vdab.domain;

import be.vdab.domain.user.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTests {

    private Validator validator;
    private Customer customer;

    @BeforeEach
    void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        customer = new Customer();
    }

    @Test
    void setCreditCardNumber_CorrectPattern() {
        customer.setCreditCardNumber("1234567890123456");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertTrue(violations.isEmpty());
    }

    @Test
    void setCreditCardNumber_MoreThan12Digits() {
        customer.setCreditCardNumber("12345678901234567");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("credit card number not valid",violations.iterator().next().getMessage());
        });
    }

    @Test
    void setCreditCardNumber_HyphenOnWrongSpot() {
        customer.setCreditCardNumber("123-45678901234567");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("credit card number not valid",violations.iterator().next().getMessage());
        });
    }

    @Test
    void setExpirationDate_CorrectPattern() {
        customer.setExpirationDate("01/22");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertTrue(violations.isEmpty());
    }

    @Test
    void setExpirationDate_TooManyDigitsAfterSlash() {
        customer.setExpirationDate("01/2022");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("expiration date not valid",violations.iterator().next().getMessage());
        });
    }

    @Test
    void setExpirationDate_MonthWithOneDigit() {
        customer.setExpirationDate("1/22");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("expiration date not valid",violations.iterator().next().getMessage());
        });
    }

    @Test
    void setExpirationDate_MonthBiggerThan12() {
        customer.setExpirationDate("13/22");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("expiration date not valid",violations.iterator().next().getMessage());
        });
    }

    @Test
    void setExpirationDate_SlashIsMissing() {
        customer.setExpirationDate("0122");
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        Assertions.assertAll(() -> {
            assertFalse(violations.isEmpty());
            assertEquals("expiration date not valid",violations.iterator().next().getMessage());
        });
    }


}
