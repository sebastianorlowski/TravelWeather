package pl.orlowski.sebastian.weather.dto;

import lombok.Builder;
import lombok.Getter;
import pl.orlowski.sebastian.weather.client.dto.*;

import java.util.List;

@Getter
@Builder
public class WeatherDayDto {

    private final Location location;
    private final Current current;
    private final Forecast forecast;
}
