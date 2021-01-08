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
public class Passenger extends AbstractEntity {

    @NonNull
    private String name;

    @OneToMany(mappedBy = "passenger",cascade = CascadeType.REFRESH)
    private List<Ticket> tickets;

}
