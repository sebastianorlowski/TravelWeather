package pl.orlowski.sebastian.weather.config;

import lombok.Getter;

@Getter
public enum ConfigWeather {

    WEATHER_DAYS(3);

    private final int value;

    private ConfigWeather(int value) {
        this.value = value;
    }

}
