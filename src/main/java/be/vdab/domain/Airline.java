package be.vdab.domain;

import be.vdab.domain.user.EmployeeAirline;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Airline extends AbstractEntity {

    @NonNull
    private String name;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;

    @ManyToMany
    private List<Airplane> airplanes;

    @OneToMany (mappedBy = "airline")
    private List<EmployeeAirline> employees;

}
