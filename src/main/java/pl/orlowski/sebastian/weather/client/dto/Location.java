package pl.orlowski.sebastian.weather.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    private String name;
    private String localtime;
    private String country;
}
