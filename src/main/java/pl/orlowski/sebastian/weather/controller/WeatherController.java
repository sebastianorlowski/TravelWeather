package pl.orlowski.sebastian.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.orlowski.sebastian.weather.dto.WeatherDayDto;
import pl.orlowski.sebastian.weather.service.WeatherService;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDayDto getWeather() {
        return weatherService.getWeather();
    }
}
