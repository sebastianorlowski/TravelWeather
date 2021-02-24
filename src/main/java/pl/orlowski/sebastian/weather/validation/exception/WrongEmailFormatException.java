package pl.orlowski.sebastian.weather.validation.exception;

public class WrongEmailFormatException extends RuntimeException{

    public WrongEmailFormatException(String message) {
        super("Wrong email format");
    }
}
