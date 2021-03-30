package pl.orlowski.sebastian.weather.validation.exception.user;

public class WrongEmailFormatException extends RuntimeException{

    public WrongEmailFormatException(String message) {
        super("Wrong email format!");
    }
}
