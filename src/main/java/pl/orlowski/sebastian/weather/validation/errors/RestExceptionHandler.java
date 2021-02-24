package pl.orlowski.sebastian.weather.validation.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.orlowski.sebastian.weather.validation.exception.*;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            UserAlreadyExistException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EmailAlreadyExistException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(PasswordIsWeakException.class)
    protected ResponseEntity<Object> handlePasswordIsWeak(
            PasswordIsWeakException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_ACCEPTABLE);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(WrongUsernameFormatException.class)
    protected ResponseEntity<Object> handleUsernameInvalid(
            WrongUsernameFormatException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_ACCEPTABLE);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(WrongEmailFormatException.class)
    protected ResponseEntity<Object> handleUsernameInvalid(
            WrongEmailFormatException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_ACCEPTABLE);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
}
