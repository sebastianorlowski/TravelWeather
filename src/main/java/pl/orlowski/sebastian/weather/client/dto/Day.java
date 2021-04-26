package pl.orlowski.sebastian.weather.client.dto;

import lombok.Getter;

@Getter
public class Day {

    private double maxtemp_c;
    private double mintemp_c;
    private double maxwind_kph;
    private String daily_chance_of_rain;
    private String daily_chance_of_snow;
}
