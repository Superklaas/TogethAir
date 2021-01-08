package be.vdab.domain.user;

import be.vdab.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Customer extends AppUser {

    @NonNull
    private int customerNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Booking> bookings;

}
