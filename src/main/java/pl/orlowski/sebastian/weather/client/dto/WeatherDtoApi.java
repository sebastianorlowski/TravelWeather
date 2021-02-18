package pl.orlowski.sebastian.weather.client.dto;

import lombok.Getter;

@Getter
public class WeatherDtoApi {

    private WeatherDataApi main;
    private String name;

}
