package pl.orlowski.sebastian.weather.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.client.WeatherClient;
import pl.orlowski.sebastian.weather.dto.WeatherDayDto;

@Service
public class WeatherService {

    private WeatherClient weatherClient;

    @Autowired
    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherService() {
    }

    public WeatherDayDto getWeather() {
        return weatherClient.getWeatherForCity("warszawa");
    }

}
