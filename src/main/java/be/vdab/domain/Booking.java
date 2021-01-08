package be.vdab.domain;

import be.vdab.domain.user.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Booking extends AbstractEntity {

    @NonNull
    private LocalDate dateBooking;

    @NonNull
    private double priceBooking;

    @NonNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @NonNull
    private boolean isPayed;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.PERSIST)
    private List<Ticket> tickets;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Customer customer;

}
