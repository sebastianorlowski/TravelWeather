package pl.orlowski.sebastian.weather.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.orlowski.sebastian.weather.client.dto.WeatherDtoApi;
import pl.orlowski.sebastian.weather.dto.WeatherDayDto;

@Component
public class WeatherClient {

    private final String API_KEY = "988ed1d6d5fa4e91a53160214212604";
    private final String URL = "http://api.weatherapi.com/v1/forecast.json?key=";

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDayDto getWeatherForCity(String city) {
        WeatherDtoApi weatherDtoApi = getWeatherMethod(API_KEY + "&q={city}&days=3&aqi=no&alerts=no",
                WeatherDtoApi.class,
                city);


        return WeatherDayDto.builder()
                .location(weatherDtoApi.getLocation())
                .current(weatherDtoApi.getCurrent())
                .forecast(weatherDtoApi.getForecast())
                .build();
    }

    public <T> T getWeatherMethod(String url, Class<T> responseType, Object...objects) {
        return restTemplate.getForObject(URL + url, responseType, objects);
    }
}
