package com.example.ejercicio_manejo_de_excepciones_p1_vivo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    protected ExceptionDetails global(Exception exception, HttpServletRequest request) {
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ResourceExistsException.class})
    @ResponseBody
    protected ExceptionDetails badRequest(Exception exception, HttpServletRequest request) {
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }
}
