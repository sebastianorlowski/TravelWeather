package pl.orlowski.sebastian.weather.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.orlowski.sebastian.weather.client.dto.WeatherDtoApi;
import pl.orlowski.sebastian.weather.config.ConfigWeather;
import pl.orlowski.sebastian.weather.dto.WeatherDayDto;
import pl.orlowski.sebastian.weather.model.Date;
import pl.orlowski.sebastian.weather.model.Destination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DateConverter {

    private final WeatherClient weatherClient;

    public List<WeatherDayDto> isPossibleToGetWeather(List<Destination> destinations) {
        LocalDate localDate = LocalDate.now();
        List<WeatherDayDto> weatherForCity = new ArrayList<>();

        for (Destination oneDestination : destinations) {
            Date dateFromJson = convertDateFromDestination(oneDestination);

            LocalDate destinationDate = LocalDate.of(dateFromJson.getYear(),
                    dateFromJson.getMonth(), dateFromJson.getDay());

            int result = (int) ChronoUnit.DAYS.between(localDate, destinationDate);

            if (result >= 0 && result <= ConfigWeather.WEATHER_DAYS.getValue()) {
                weatherForCity.add(weatherClient.getWeatherForCity(oneDestination.getPlace()));
            }
        }
        return weatherForCity;
    }

    public Date convertDateFromDestination(Destination destination) {
        String dateFromDestination = destination.getDate().substring(0, destination.getDate().length() - 5);
        String[] dateGroups = dateFromDestination.trim().split("-");

        return new Date(Integer.parseInt(dateGroups[0]),
                Integer.parseInt(dateGroups[1]),
                Integer.parseInt(dateGroups[2]));
    }

}
