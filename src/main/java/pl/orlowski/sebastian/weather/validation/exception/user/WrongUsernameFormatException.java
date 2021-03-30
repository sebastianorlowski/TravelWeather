package pl.orlowski.sebastian.weather.validation.exception.user;

public class WrongUsernameFormatException extends RuntimeException{

    public WrongUsernameFormatException(String message) {
        super("Username must have 5 - 15 characters length and contain (Aa-zZ 0-9 characters).");
    }
}
