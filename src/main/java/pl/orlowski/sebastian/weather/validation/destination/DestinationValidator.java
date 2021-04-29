package pl.orlowski.sebastian.weather.validation.destination;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.orlowski.sebastian.weather.dto.DestinationDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.repository.DestinationRepository;
import pl.orlowski.sebastian.weather.repository.TripRepository;
import pl.orlowski.sebastian.weather.validation.exception.EmptyValueException;
import pl.orlowski.sebastian.weather.validation.exception.destination.DestinationNotExistException;
import pl.orlowski.sebastian.weather.validation.exception.destination.WrongDataException;
import pl.orlowski.sebastian.weather.validation.exception.user.AccessException;
import pl.orlowski.sebastian.weather.validation.trip.TripValidator;

@Component
@RequiredArgsConstructor
public class DestinationValidator {

    private final DestinationRepository destinationRepository;
    private final TripValidator tripValidator;
    private final DestinationInfoChecker destinationInfoChecker;

    public boolean checkTrip(Long id, String username) {
        return tripValidator.checkUserAndTripExist(id, username);
    }

    public boolean checkUserDestination(Long id, String username) {
        Destination destination = destinationRepository.getOne(id);
        Trip trip = destination.getTrip();
        User user = trip.getUser();
        return user.getUsername().equals(username);
    }

    public void checkDestination(Long id, String username) {
        if (id == 0) {
            throw new EmptyValueException("");
        }

        if (!destinationRepository.existsById(id) && checkTrip(id, username)) {
            throw new DestinationNotExistException("");
        }

        if (!checkUserDestination(id, username)) {
            throw new AccessException("");
        }
    }

    public void checkDestination(Long id, DestinationDto destinationDto, String username) {
        if (id == 0) {
            throw new EmptyValueException("");
        }
        if (!checkTrip(id, username)) {
            throw new AccessException("");
        }

        if (!destinationInfoChecker.isDateValid(destinationDto.getDate())) {
            throw new WrongDataException("");
        }
    }

}
