package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.DestinationDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.repository.DestinationRepository;
import pl.orlowski.sebastian.weather.repository.TripRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final TripRepository tripRepository;

    public void createDestination(DestinationDto destinationDto, Long id) {
        Destination destination = new Destination();
        destination.setHours(destinationDto.getHours());
        destination.setDay(destinationDto.getDay());
        destination.setMonth(destinationDto.getMonth());
        destination.setYear(destinationDto.getYear());
        destination.setPlace(destinationDto.getPlace());

        destinationRepository.save(destination);
    }

    public void updateDestination(DestinationDto destinationDto, Long id) {
        Destination destination = new Destination();
        destination.setId(id);
        destination.setHours(destinationDto.getHours());
        destination.setDay(destinationDto.getDay());
        destination.setMonth(destinationDto.getMonth());
        destination.setYear(destinationDto.getYear());
        destination.setPlace(destinationDto.getPlace());
        destination.setTrip(tripRepository
                .findTripById(destinationRepository.findTripById(id)));

        destinationRepository.save(destination);
    }

    public Destination showDestinationById(Long id) {
        return destinationRepository.getOne(id);
    }

    public void removeDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
