package pl.orlowski.sebastian.weather.model;

import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
public class TravelToAirport {

    private Time time;
    private Date date;
    private String place;
}
