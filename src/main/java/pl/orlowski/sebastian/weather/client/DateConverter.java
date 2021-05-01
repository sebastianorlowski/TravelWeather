package pl.orlowski.sebastian.weather.client;

import pl.orlowski.sebastian.weather.model.Date;
import pl.orlowski.sebastian.weather.model.Destination;

import java.time.LocalDate;
import java.util.List;

public class DateConverter {

    //    public List<Data> convertDataInDestinations(List<Destination> destinations) {
//
//    }

    public boolean isPossibleToGetWeather(List<Destination> destinations) {
        int year = 0;
        int month = 0;
        int day = 0;
        LocalDate localDate = LocalDate.now();
        Date date = new Date(
                localDate.getYear(),
                localDate.getMonthValue(),
                localDate.getDayOfMonth());




    }

    public String convertDateFromDestination(Destination destination) {
        String dateFromDestination = destination.getDate().substring(0, destination.getDate().length() - 5);
        String[] dateGroups = dateFromDestination.split("-");
        Date date = new Date(Integer.parseInt(dateGroups[0]),
                Integer.parseInt(dateGroups[1]),
                Integer.parseInt(dateGroups[2]));


    }

}
