package pl.orlowski.sebastian.weather.validation.destination;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.orlowski.sebastian.weather.validation.error.ApiError;
import pl.orlowski.sebastian.weather.validation.exception.EmptyValueException;
import pl.orlowski.sebastian.weather.validation.exception.destination.DestinationNotExistException;
import pl.orlowski.sebastian.weather.validation.exception.destination.WrongDataException;

@RestControllerAdvice
public class DestinationRestExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(WrongDataException.class)
    private ResponseEntity<Object> handleDataValue(WrongDataException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }


    @ExceptionHandler(DestinationNotExistException.class)
    private ResponseEntity<Object> handleDestinationNotExist(DestinationNotExistException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }



}
