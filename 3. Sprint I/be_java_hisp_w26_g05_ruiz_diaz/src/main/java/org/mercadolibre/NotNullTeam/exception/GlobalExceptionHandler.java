package org.mercadolibre.NotNullTeam.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.mercadolibre.NotNullTeam.exception.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    protected ExceptionDetails global(Exception exception, HttpServletRequest request) {
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DiscountMustBeGreaterThanZeroException.class})
    @ResponseBody
    protected ExceptionDetails discountMustBeGreaterThanZeroException(
            Exception exception, HttpServletRequest request
    ) {
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ProductPromoWithoutHasPromoOnFalseException.class})
    @ResponseBody
    protected ExceptionDetails productPromoWithoutHasPromoOnFalseException(
            Exception exception, HttpServletRequest request
    ) {
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }


    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({UserAlreadyFollowedException.class})
    @ResponseBody
    protected ExceptionDetails userAlreadyFollowedException(Exception exception, HttpServletRequest request) {
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({PostAlreadyIsFavoriteExceptionDTO.class})
    @ResponseBody
    protected ExceptionDetails postAlreadyIsFavoriteExceptionDTO(Exception exception, HttpServletRequest request) {
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }
}
