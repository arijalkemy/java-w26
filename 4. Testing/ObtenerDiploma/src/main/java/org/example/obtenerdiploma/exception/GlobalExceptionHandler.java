package org.example.obtenerdiploma.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.example.obtenerdiploma.exception.error.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    protected ExceptionDetails notFound(Exception exception, HttpServletRequest request) {
        return new ExceptionDetails(LocalDateTime.now(), exception, request);
    }


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    @ResponseBody
//    protected ExceptionDetails validations(Exception exception, HttpServletRequest request) {
//        return new ExceptionDetails(LocalDateTime.now(), exception, request);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> customValidationException(MethodArgumentNotValidException e) {
        List<FieldError> errorFields = e.getFieldErrors();

        Map<String, String> formattedErrors = new HashMap<>();
        for (FieldError field : errorFields) {
            formattedErrors.put(field.getField(), field.getDefaultMessage());
        }

        return new ResponseEntity<>(formattedErrors, HttpStatus.BAD_REQUEST);
    }
}
