package pl.orlowski.sebastian.weather.client.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class Forecastday {

    private String date;
    private Day day;
    private List<Hour> hour;
}
