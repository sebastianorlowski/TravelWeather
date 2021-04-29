package pl.orlowski.sebastian.weather.validation.destination;

import org.springframework.stereotype.Component;

@Component
public class DestinationInfoChecker {

    protected boolean isDateValid(String date) {
        String dateRegex = ("^20[0-9]{2}-([0-2]?[0-9])-([0-3]?[0-9])" +
                "\\s(([01]?[0-9]|2[0-3]):[0-5][0-9])$");

        return dateRegex.equals(date);
    }

    protected boolean placeValid(String place) {

        return true;
    }
}
