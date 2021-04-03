package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.TripDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.repository.DestinationRepository;
import pl.orlowski.sebastian.weather.repository.TripRepository;
import pl.orlowski.sebastian.weather.repository.UserRepository;
import pl.orlowski.sebastian.weather.validation.trip.TripValidator;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final DestinationRepository destinationRepository;
    private final TripValidator tripValidator;

    public void save(TripDto tripDto, String username) {
        tripValidator.createTripValidator(tripDto);
        Trip trip = new Trip();
        trip.setName(tripDto.getName());
        trip.setUser(userRepository.findByUsername(username));

        tripRepository.save(trip);
    }

    public Collection<Trip> showTripByUsername(String username) {
        tripValidator.showTripByUsernameValidator(username);
        User user = userRepository.findByUsername(username);
        return tripRepository.findTripByUser(user);
    }

    public Trip showTripById(Long id, String username) {
        tripValidator.showTripValidator(id, username);
        Collection<Destination> destinations = destinationRepository.findByTripId(id);
        Trip trip = tripRepository.findTripById(id);
        trip.setDestinations(destinations);
        return trip;
    }

    public void updateTrip(TripDto tripDto, Long id, String username) {
        tripValidator.createTripValidator(tripDto);
        Trip trip = new Trip();
        trip.setId(id);
        trip.setName(tripDto.getName());
        trip.setUser(userRepository.findByUsername(username));

        tripRepository.save(trip);
    }

    @Transactional
    public void removeTrip(Long id, String username) {
        tripValidator.showTripValidator(id, username);
        destinationRepository.removeByTripId(id);
        tripRepository.deleteById(id);
    }

}
