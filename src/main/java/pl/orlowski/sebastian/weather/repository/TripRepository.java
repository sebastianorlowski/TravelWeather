package pl.orlowski.sebastian.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.model.User;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findTripByUser(User user);
    Trip findTripById(Long id);
    boolean existsTripById(Long id);
}
