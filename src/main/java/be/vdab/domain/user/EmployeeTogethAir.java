package be.vdab.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmployeeTogethAir extends AppUser {

    @NonNull
    private int employeeNumber;

}
