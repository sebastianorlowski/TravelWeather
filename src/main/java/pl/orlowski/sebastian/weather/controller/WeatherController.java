package pl.orlowski.sebastian.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.dto.WeatherDayDto;
import pl.orlowski.sebastian.weather.service.WeatherService;

@RestController
@RequestMapping("api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;


//    @GetMapping()
//    public WeatherDayDto getWeather() {
//        return weatherService.getWeather();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showWeatherForTrip(@PathVariable Long id,
                                                UsernamePasswordAuthenticationToken user) {
        weatherService.getWeatherForTrip(id, user.getName());
        return ResponseEntity
                .status(200)
                .body("");
    }
}
