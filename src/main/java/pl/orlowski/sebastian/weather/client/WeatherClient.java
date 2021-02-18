package pl.orlowski.sebastian.weather.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.orlowski.sebastian.weather.client.dto.WeatherDtoApi;
import pl.orlowski.sebastian.weather.dto.WeatherDto;

@Component
public class WeatherClient {

    private final String API_KEY = "25635facab2ab6d0fa5d4de6786f716a";
    private final String URL = "https://api.openweathermap.org/data/2.5/weather?";

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherForCity(String city) {
        WeatherDtoApi weatherDtoApi = getWeatherMethod("q={city}&units=metric&appid=" + API_KEY,
                WeatherDtoApi.class,
                city);


        return WeatherDto.builder()
                .city(weatherDtoApi.getName())
                .temperature(weatherDtoApi.getMain().getTemp())
                .build();
    }

    public <T> T getWeatherMethod(String url, Class<T> responseType, Object...objects) {
        return restTemplate.getForObject(URL + url, responseType, objects);
    }
}
