package pl.orlowski.sebastian.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.orlowski.sebastian.weather.model.Destination;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    void removeByTripId(Long id);

    List<Destination> findByTripId(Long id);
}
