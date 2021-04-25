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

    public void createDestination(DestinationDto destinationDto, Long id, String username) {
        destinationValidator.checkDestination(id, destinationDto, username);
        Destination destination = new Destination();
        destinationInfo(destinationDto, destination, id);
    }

    private void destinationInfo(DestinationDto destinationDto, Destination destination, Long id) {
     Trip trip = tripRepository.findTripById(id);
        destination.setHours(destinationDto.getHours());
        destination.setDay(destinationDto.getDay());
        destination.setMonth(destinationDto.getMonth());
        destination.setYear(destinationDto.getYear());
        destination.setPlace(destinationDto.getPlace());
        destination.setTrip(trip);

        destinationRepository.save(destination);
    }

    public void updateDestination(DestinationDto destinationDto, Long id, String username) {
        destinationValidator.checkDestination(id, destinationDto, username);

        Destination destination = new Destination();
        destination.setId(id);
        Trip trip = destination.getTrip();
        destinationInfo(destinationDto, destination, trip.getId());
    }

    public Destination showDestinationById(Long id, String username) {
        destinationValidator.checkShowDestination(id, username);
        return destinationRepository.getOne(id);
    }

    public void removeDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
