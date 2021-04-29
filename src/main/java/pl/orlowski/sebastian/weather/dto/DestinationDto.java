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
    private String date;
    private String place;

    @JsonIgnore
    private Trip trip;
}
