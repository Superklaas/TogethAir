package be.vdab.domain.user;

import be.vdab.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Customer extends AppUser {

    @Pattern(regexp = "^[0-9]{4}[-\\.\\s]?[0-9]{4}[-\\.\\s]?[0-9]{4}[-\\.\\s]?[0-9]{4}$",
            message = "credit card number not valid")
    private String creditCardNumber;

    @Pattern(regexp = "^[1-12][-\\.\\s\\/]?[0-9]{2}$",
            message = "expiration date not valid")
    private String expirationDate;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Booking> bookings;

}
