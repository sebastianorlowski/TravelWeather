package pl.orlowski.sebastian.weather.validation.exception.user;

public class AccessException extends RuntimeException{

    public AccessException(String message){
        super("You dont have access!");
    }
}
