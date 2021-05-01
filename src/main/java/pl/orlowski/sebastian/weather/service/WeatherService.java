package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.client.WeatherClient;
import pl.orlowski.sebastian.weather.dto.WeatherDayDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.repository.TripRepository;
import pl.orlowski.sebastian.weather.validation.trip.TripValidator;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;
    private final TripValidator tripValidator;
    private final TripRepository tripRepository;

    public WeatherDayDto getWeather() {
        return weatherClient.getWeatherForCity("warszawa");
    }

    public void getWeatherForTrip(Long id, String username) {
        tripValidator.showTripValidator(id, username);

        Trip trip = tripRepository.findTripById(id);
        List<Destination> destinations = trip.getDestinations();


    }

}
