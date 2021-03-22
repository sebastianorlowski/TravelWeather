package pl.orlowski.sebastian.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.orlowski.sebastian.weather.model.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
