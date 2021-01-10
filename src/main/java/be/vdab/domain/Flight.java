package be.vdab.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Flight extends AbstractEntity {

    @NonNull
    private LocalDateTime departureTime;

    @NonNull
    private LocalDateTime arrivalTime;

    @NonNull
    @Digits(integer = 5, fraction = 2,
            message = "basePrice can contain 5 digits in integer and 2 digits in fraction")
    private double basePrice;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Airport departure;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Airport destination;

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "travel_class")
    private Map<TravelClass,Integer> bookedSeats;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Airplane airplane;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Airline airline;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Discount discount;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.PERSIST)
    private List<Ticket> tickets;

}
