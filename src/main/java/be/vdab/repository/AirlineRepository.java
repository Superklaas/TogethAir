package be.vdab.repository;

import be.vdab.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline,Integer> {

    public Airline findAirlineByNameContaining(String name);

}
