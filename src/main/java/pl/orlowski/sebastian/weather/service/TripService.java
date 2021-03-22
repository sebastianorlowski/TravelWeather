package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.TripDto;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.repository.TripRepository;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public Trip save(TripDto tripDto, Authentication auth) {
        Trip trip = new Trip();
        trip.setName(tripDto.getName());
        trip.setUser((User) auth.getPrincipal());

        return tripRepository.save(trip);
    }

}
