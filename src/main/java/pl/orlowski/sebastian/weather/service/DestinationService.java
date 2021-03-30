package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.DestinationDto;
import pl.orlowski.sebastian.weather.dto.TripDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.repository.DestinationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public Destination createDestination(DestinationDto destinationDto, Trip trip) {
        Destination destination = new Destination();
        destination.setHours(destinationDto.getHours());
        destination.setDay(destinationDto.getDay());
        destination.setMonth(destinationDto.getDay());
        destination.setYear(destinationDto.getYear());
        destination.setPlace(destinationDto.getPlace());
        destination.setTrip(trip);

        return destinationRepository.save(destination);
    }

    public List<Destination> findDestinationsByTrip(Trip trip) {
        return destinationRepository.findByTrip(trip);
    }

    public void removeDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
