package be.vdab.domain;

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
public class Discount extends AbstractEntity {

    private final int togethAirRate = 5;

    @NonNull
    private TimeCategory timeCategory;

    @NonNull
    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    private Map<TravelClass,Integer> travelClassRate;

    @NonNull
    @ElementCollection
    private Map<Integer,Integer> volumeDiscount;

    @OneToMany(mappedBy = "discount")
    private List<Flight> flights;

}
