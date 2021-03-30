package pl.orlowski.sebastian.weather.validation.exception.user;

public class EmptyValueException extends RuntimeException{

    public EmptyValueException(String message) {
        super("Value cannot be empty!");
    }
}
