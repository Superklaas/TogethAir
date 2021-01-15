package be.vdab.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "departure", cascade = CascadeType.REFRESH)
    private List<Flight> departingFlights;

    @JsonManagedReference
    @OneToMany(mappedBy = "destination", cascade = CascadeType.REFRESH)
    private List<Flight> arrivingFlights;

}
