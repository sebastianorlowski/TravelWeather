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

    public boolean checkUserAndTripExist(Long id, String username) {
        Trip trip = tripRepository.findTripById(id);
        if (id == null || !tripRepository.existsTripById(id)) {
            throw new TripNotExistException("");
        }
        return trip.getUser().getUsername().equals(username)
                && tripRepository.existsTripById(id);
    }

    public void createTripValidator(TripDto tripDto) {
            if (tripDto.getName().isEmpty()) {
                throw new EmptyValueException("");
            }
    }

    public void showTripValidator(Long id, String username) {

        if (!checkUserAndTripExist(id, username)) {
            throw new AccessException("");
        }
    }

    public void showTripByUsernameValidator(String username) {
        if (userRepository.findByUsername(username) == null) {
            throw new UsernameNotFoundException("");
        }
    }

    public boolean isExistTrip(Long id) {
        return tripRepository.existsTripById(id);
    }
}
