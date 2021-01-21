package be.vdab.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Setter
public class Flight extends AbstractEntity {

    @NonNull
    private LocalDateTime departureTime;

    @NonNull
    private LocalDateTime arrivalTime;

    @NonNull
    @Digits(integer = 5, fraction = 2,
            message = "basePrice can contain 5 digits in integer and 2 digits in fraction")
    private double basePrice;

    @ManyToOne
    private Airport departure;

    @ManyToOne
    private Airport destination;

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "travel_class")
    private Map<TravelClass,Integer> bookedSeats;

    @ManyToOne
    private Airplane airplane;

    @ManyToOne
    private Airline airline;

    @ManyToOne
    private Discount discount;

}
