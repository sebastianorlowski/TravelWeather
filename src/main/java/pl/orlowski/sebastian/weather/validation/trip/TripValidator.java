package pl.orlowski.sebastian.weather.validation.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.orlowski.sebastian.weather.dto.TripDto;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.repository.TripRepository;
import pl.orlowski.sebastian.weather.repository.UserRepository;
import pl.orlowski.sebastian.weather.validation.exception.EmptyValueException;
import pl.orlowski.sebastian.weather.validation.exception.trip.TripNotExistException;
import pl.orlowski.sebastian.weather.validation.exception.user.AccessException;

@Component
@RequiredArgsConstructor
public class TripValidator {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public boolean checkUser(Long id, String username) {
        Trip trip = tripRepository.findTripById(id);
        return trip.getUser().getUsername().equals(username);
    }

    public void createTripValidator(TripDto tripDto) {
            if (tripDto.getName().isEmpty()) {
                throw new EmptyValueException("");
            }
    }

    public void showTripValidator(Long id, String username) {
        if (id == null || !tripRepository.existsById(id) ) {
            throw new TripNotExistException("");
        }
        if (!checkUser(id, username)) {
            throw new AccessException("");
        }
    }

    public void showTripByUsernameValidator(String username) {
        if (userRepository.findByUsername(username) == null) {
            throw new UsernameNotFoundException("");
        }
    }
}
