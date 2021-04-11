package pl.orlowski.sebastian.weather.validation.destination;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import pl.orlowski.sebastian.weather.dto.DestinationDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.repository.DestinationRepository;
import pl.orlowski.sebastian.weather.repository.TripRepository;
import pl.orlowski.sebastian.weather.service.DestinationService;
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
    private final TripRepository tripRepository;
    private final DestinationInfoChecker destinationInfoChecker;

    public boolean checkTrip(Long id, String username) {
        return tripValidator.checkUser(id, username);
    }

    public boolean checkUserDestination(Long id, String username) {
        Destination destination = destinationRepository.getOne(id);
        Trip trip = destination.getTrip();
        return trip.getUser().getUsername().equals(username);
    }

    public void checkShowDestination(Long id, String username) {
        if (id == 0) {
            throw new EmptyValueException("");
        }

        if (!destinationRepository.findById(id).isPresent()) {
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
        if (!destinationInfoChecker.isDateValid(
                destinationDto.getHours(),
                destinationDto.getDay(),
                destinationDto.getMonth(),
                destinationDto.getYear())) {
            throw new WrongDataException("");
        }
    }

}
