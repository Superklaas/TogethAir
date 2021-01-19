package be.vdab.domain;

import be.vdab.domain.user.EmployeeAirline;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class Airline extends AbstractEntity {

    @NonNull
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;

    @ManyToMany
    private List<Airplane> airplanes;

    @OneToMany (mappedBy = "airline")
    private List<EmployeeAirline> employees;

}
