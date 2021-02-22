package pl.orlowski.sebastian.weather.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class Destination {

    private int hours;
    private int day;
    private int month;
    private int year;
    private String place;

    public Destination(int hours, int day, int month, int year, String place) {
        this.hours = hours;
        this.day = day;
        this.month = month;
        this.year = year;
        this.place = place;
    }
}
