package pl.orlowski.sebastian.weather.validation.exception.trip;

public class TripNotExistException extends RuntimeException{

    public TripNotExistException(String message) {
        super("Trip doesnt exist!");
    }
}
