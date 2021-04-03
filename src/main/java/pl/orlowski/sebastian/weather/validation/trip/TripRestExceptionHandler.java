package pl.orlowski.sebastian.weather.validation.trip;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.orlowski.sebastian.weather.validation.error.ApiError;
import pl.orlowski.sebastian.weather.validation.exception.EmptyValueException;
import pl.orlowski.sebastian.weather.validation.exception.trip.TripNotExistException;

@RestControllerAdvice
public class TripRestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(EmptyValueException.class)
    private ResponseEntity<Object> handleEmptyValue(EmptyValueException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(TripNotExistException.class)
    private ResponseEntity<Object> handleTripNotExist(TripNotExistException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }


}
