package pl.orlowski.sebastian.weather.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DestinationDto {
    private int hours;
    private int day;
    private int month;
    private int year;
    private String place;
}
