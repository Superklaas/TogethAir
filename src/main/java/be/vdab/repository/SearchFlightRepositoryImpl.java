package be.vdab.repository;

import be.vdab.domain.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class SearchFlightRepositoryImpl implements SearchFlightRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Flight> searchFlights(String dateDepartureString, Double basePrice, String departureName,
                                      String destinationName, String airlineName) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(Flight.class);
        Root<Flight> from = query.from(Flight.class);

        Predicate predicate = criteriaBuilder.conjunction();

        if(dateDepartureString != null) {
            LocalDate dateDeparture = LocalDate.parse(dateDepartureString);
            LocalDateTime startOfDay = dateDeparture.atStartOfDay();
            LocalDateTime endOfDay = dateDeparture.atTime(23,59);
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.between(from.get("departureTime"), startOfDay,endOfDay));
        }
        if(basePrice != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(from.get("basePrice"),basePrice));
        }
        if(departureName != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(from.get("departure").get("name"),
                    "%"+departureName+"%"));
        }
        if(destinationName != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(from.get("destination").get("name"),
                    "%"+destinationName+"%"));
        }
        if(airlineName != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(from.get("airline").get("name"),
                    "%"+airlineName+"%"));
        }

        return entityManager.createQuery(query.where(predicate)).getResultList();

    }

}
