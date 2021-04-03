package pl.orlowski.sebastian.weather.validation.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.orlowski.sebastian.weather.validation.error.ApiError;
import pl.orlowski.sebastian.weather.validation.exception.EmptyValueException;
import pl.orlowski.sebastian.weather.validation.exception.user.*;

@RestControllerAdvice
public class UserRestExceptionHandler extends ResponseEntityExceptionHandler {

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
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(WrongUsernameFormatException.class)
    protected ResponseEntity<Object> handleUsernameInvalid(
            WrongUsernameFormatException ex) {
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(WrongEmailFormatException.class)
    protected ResponseEntity<Object> handleEmailInvalid(
            WrongEmailFormatException ex) {
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(EmptyValueException.class)
    protected ResponseEntity<Object> handleEmptyValue(
            EmptyValueException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(AccessException.class)
    protected ResponseEntity<Object> handleAccessException(
            AccessException ex) {
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
}
