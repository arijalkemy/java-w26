package org.example.templatemvc.Common.HandleException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({Error.class})
    @ResponseBody
    protected ExceptionDetails global(Exception exception, HttpServletRequest request) {
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }
}
