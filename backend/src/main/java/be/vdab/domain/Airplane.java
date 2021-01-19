package be.vdab.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Airplane extends AbstractEntity {

    @NonNull
    private String brand;

    @NonNull
    private String model;

    @NonNull
    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "travel_class")
    private Map<TravelClass,Integer> capacity;

    @ManyToMany(mappedBy = "airplanes", cascade = CascadeType.REFRESH)
    private List<Airline> airlines;

    @JsonManagedReference
    @OneToMany(mappedBy = "airplane", cascade = CascadeType.REFRESH)
    private List<Flight> flights;

}
