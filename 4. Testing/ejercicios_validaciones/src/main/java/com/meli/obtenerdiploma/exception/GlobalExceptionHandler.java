package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorResponseDto;
import com.meli.obtenerdiploma.model.ValidationErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<ValidationErrorDto> validations = new ArrayList<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            validations.add(new ValidationErrorDto(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        return new ResponseEntity<>(
            ErrorResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST)
                .path(request.getRequestURI())
                .message("Error...")
                .validations(validations)
                .build(),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValid(HttpMessageNotReadableException ex, HttpServletRequest request) {
        return new ResponseEntity<>(
            ErrorResponseDto.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST)
                .path(request.getRequestURI())
                .message("La request tiene campos faltantes o está mal formada.")
                .build(),
            HttpStatus.BAD_REQUEST
        );
    }
}