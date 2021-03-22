package pl.orlowski.sebastian.weather.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationDto {
    private int hours;
    private int day;
    private int month;
    private int year;
    private String place;
}
