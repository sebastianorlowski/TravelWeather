package pl.orlowski.sebastian.weather.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDto {

    private String city;
    private float temperature;
}
