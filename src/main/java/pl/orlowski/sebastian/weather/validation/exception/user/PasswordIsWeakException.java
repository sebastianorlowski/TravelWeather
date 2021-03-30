package pl.orlowski.sebastian.weather.validation.exception.user;

public class PasswordIsWeakException extends RuntimeException {

    public PasswordIsWeakException(String message) {
        super("This password is too weak! Must contain 8-30 characters and at least one upper character!");
    }


}
