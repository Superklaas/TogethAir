package be.vdab.domain;

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
public class Airport extends AbstractEntity {

    @NonNull
    private String name;

    @NonNull
    private String city;

    private String region;

    private String country;

    @NonNull
    private String airportCode;

    @OneToMany(mappedBy = "departure", cascade = CascadeType.REFRESH)
    private List<Flight> departingFlights;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.REFRESH)
    private List<Flight> arrivingFlights;

}
