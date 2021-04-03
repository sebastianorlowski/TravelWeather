package pl.orlowski.sebastian.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.orlowski.sebastian.weather.model.Trip;

@Getter
@Setter
@Builder
public class DestinationDto {

    private Long id;
    private int hours;
    private int day;
    private int month;
    private int year;
    private String place;

    @JsonIgnore
    private Trip trip;
}
