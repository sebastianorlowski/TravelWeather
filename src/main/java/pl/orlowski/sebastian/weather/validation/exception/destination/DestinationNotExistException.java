package pl.orlowski.sebastian.weather.validation.exception.destination;

public class DestinationNotExistException extends RuntimeException{
    public DestinationNotExistException(String message) {
        super("Destination not exist!");
    }
}
