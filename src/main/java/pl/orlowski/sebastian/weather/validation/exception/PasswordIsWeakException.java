package pl.orlowski.sebastian.weather.validation.exception;

public class PasswordIsWeakException extends RuntimeException {

    public PasswordIsWeakException(String message) {
        super("This password is too weak! Must contain 8-30 characters.");
    }


}
