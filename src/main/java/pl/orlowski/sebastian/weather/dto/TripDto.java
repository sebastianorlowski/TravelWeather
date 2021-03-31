package pl.orlowski.sebastian.weather.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.User;

import java.util.Collection;

@Getter
@Setter
@RequiredArgsConstructor
public class TripDto {

    private Long id;
    private String name;
}
