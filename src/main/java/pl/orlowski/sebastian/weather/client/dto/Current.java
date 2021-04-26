package pl.orlowski.sebastian.weather.client.dto;

import lombok.Getter;

@Getter
public class Current {

    private double temp_c;
    private String last_updated;
    private Condition condition;
}
