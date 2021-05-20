package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.DestinationDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.repository.DestinationRepository;
import pl.orlowski.sebastian.weather.repository.TripRepository;
import pl.orlowski.sebastian.weather.validation.destination.DestinationValidator;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final TripRepository tripRepository;
    private final DestinationValidator destinationValidator;

    public Destination createDestination(DestinationDto destinationDto, Long id, String username) {
        destinationValidator.checkDestination(id, destinationDto, username);
        Destination destination = new Destination();
        return destinationInfo(destinationDto, destination, id);
    }

    private Destination destinationInfo(DestinationDto destinationDto, Destination destination, Long id) {
     Trip trip = tripRepository.findTripById(id);
        destination.setDate(destinationDto.getDate());
        destination.setPlace(destinationDto.getPlace());
        destination.setTrip(trip);

        return destinationRepository.save(destination);
    }

    public Destination updateDestination(DestinationDto destinationDto, Long id, String username, Long tripId) {
        destinationValidator.checkDestination(id, destinationDto, username);

        Destination destination = new Destination();
        destination.setId(id);
        return destinationInfo(destinationDto, destination, tripId);
    }

    public Destination showDestinationById(Long id, String username) {
        destinationValidator.checkDestination(id, username);
        return destinationRepository.getOne(id);
    }

    public void removeDestination(Long id, String username) {
        destinationValidator.checkDestination(id, username);
        destinationRepository.deleteById(id);
    }
}
