package pl.orlowski.sebastian.weather.validation.destination;

import org.springframework.stereotype.Component;

@Component
public class DestinationInfoChecker {

    protected boolean isDateValid(int hours, int day, int month, int year) {
        String hoursRegex = "(2[0-3]|1[0-9]|0[0-9])$";
        String dayRegex = "(3[01]|[12][0-9]|0[1-9])$";
        String monthRegex = "(1[0-2]|[1-9])$";
        String yearRegex = "[0-9]{4}$";

        return String.valueOf(hours).matches(hoursRegex) &&
                String.valueOf(day).matches(dayRegex) &&
                String.valueOf(month).matches(monthRegex) &&
                String.valueOf(year).matches(yearRegex);
    }

    protected boolean placeValid(String place) {

        return true;
    }
}
