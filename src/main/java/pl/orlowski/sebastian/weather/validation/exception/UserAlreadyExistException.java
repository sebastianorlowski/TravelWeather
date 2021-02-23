package pl.orlowski.sebastian.weather.validation.exception;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String username) {
        super("This user is already exist: " + username);
    }
}
