package pl.orlowski.sebastian.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.dto.WeatherDayDto;
import pl.orlowski.sebastian.weather.service.WeatherService;

import java.util.List;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{tripId}")
    public ResponseEntity<?> showWeatherForTrip(@PathVariable Long tripId,
                                                UsernamePasswordAuthenticationToken user) {
        List<WeatherDayDto> weather = weatherService.getWeatherForTrip(tripId, user.getName());

        return new ResponseEntity<>(weather, HttpStatus.OK);
    }
}
