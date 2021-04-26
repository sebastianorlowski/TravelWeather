package pl.orlowski.sebastian.weather.client.dto;

import lombok.Getter;

@Getter
public class WeatherDtoApi {
    private Location location;
    private Current current;
    private Forecast forecast;
}
