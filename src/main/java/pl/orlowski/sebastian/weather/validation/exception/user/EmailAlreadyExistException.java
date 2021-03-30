package pl.orlowski.sebastian.weather.validation.exception.user;

public class EmailAlreadyExistException extends RuntimeException {

    public EmailAlreadyExistException(String email) {
        super("This email is already exist: " + email);
    }
}
