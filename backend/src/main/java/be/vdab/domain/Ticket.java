package be.vdab.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Ticket extends AbstractEntity {

    @NonNull
    @Enumerated(EnumType.STRING)
    private TravelClass travelClass;

    @ManyToOne
    private Flight flight;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Booking booking;

}
