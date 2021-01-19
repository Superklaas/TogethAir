package be.vdab.domain.user;

import be.vdab.domain.Booking;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer extends AppUser {

    @Pattern(regexp = "^[0-9]{4}[-\\.\\s]?[0-9]{4}[-\\.\\s]?[0-9]{4}[-\\.\\s]?[0-9]{4}$",
            message = "credit card number not valid")
    private String creditCardNumber;

    @Pattern(regexp = "(0[1-9]|1[0-2])\\/([0-9]{2})$",
            message = "expiration date not valid")
    private String expirationDate;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Booking> bookings;

}
