package be.vdab.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class Airport extends AbstractEntity {

    @NonNull
    private String name;

    private String country;

    private String region;

    private String airportCode;

    @OneToMany(mappedBy = "departure", cascade = CascadeType.REFRESH)
    private List<Flight> departingFlights;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.REFRESH)
    private List<Flight> arrivingFlights;

}
