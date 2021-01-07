package be.vdab.domain;

import be.vdab.domain.user.EmployeeAirline;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;

    @ManyToMany
    private List<Airplane> airplanes;

    @OneToMany (mappedBy = "airline")
    private List<EmployeeAirline> employees;

    public Airline(String name) {
        this.name = name;
    }

    public Airline() {}


}
