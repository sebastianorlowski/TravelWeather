package pl.orlowski.sebastian.weather.validation.exception.destination;

public class WrongDataException extends RuntimeException{

    public WrongDataException(String message) {
        super("Wrong date!");
    }
}
