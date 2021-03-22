package pl.orlowski.sebastian.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.orlowski.sebastian.weather.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
