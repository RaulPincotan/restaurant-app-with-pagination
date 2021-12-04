package tema7.restaurant.exceptions;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestaurantControllerAdvice {

    @ExceptionHandler(RestaurantException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFound(RestaurantException exception) {
        return new ApiError(exception.getMessage());
    }

}

@Value
class ApiError {
    String message;
}
