package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.TripDto;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.repository.TripRepository;
import pl.orlowski.sebastian.weather.repository.UserRepository;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public void save(TripDto tripDto, String username) {
        Trip trip = new Trip();
        trip.setName(tripDto.getName());
        trip.setUser(userRepository.findByUsername(username));

        tripRepository.save(trip);
    }

    public Collection<Trip> findTripByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return tripRepository.findTripByUser(user);
    }

    public void removeTrip(Long id) {
        tripRepository.deleteById(id);
    }

}
