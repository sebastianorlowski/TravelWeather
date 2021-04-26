package pl.orlowski.sebastian.weather.client.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class Forecast {

    private List<Forecastday> forecastday;
}
