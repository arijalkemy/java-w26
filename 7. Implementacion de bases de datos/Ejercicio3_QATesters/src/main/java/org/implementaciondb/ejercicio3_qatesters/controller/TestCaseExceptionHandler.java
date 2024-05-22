package org.implementaciondb.ejercicio3_qatesters.controller;

import jakarta.validation.ConstraintViolationException;
import org.implementaciondb.ejercicio3_qatesters.dto.ErrorDto;
import org.implementaciondb.ejercicio3_qatesters.dto.ValidErrorDto;
import org.implementaciondb.ejercicio3_qatesters.exception.BadRequestException;
import org.implementaciondb.ejercicio3_qatesters.exception.NoContentException;
import org.implementaciondb.ejercicio3_qatesters.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice
public class TestCaseExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> notFound(NotFoundException ex, WebRequest webRequest) {
        ErrorDto exdto = new ErrorDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDto> badRequest(BadRequestException ex, WebRequest webRequest) {
        ErrorDto exdto = new ErrorDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<ErrorDto> badRequest(NoContentException ex, WebRequest webRequest) {
        ErrorDto exdto = new ErrorDto("No Content", webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidErrorDto> handlerMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            WebRequest webRequest
    ) throws Exception {
        BindingResult result = ex.getBindingResult();
        Map<String, String> formattedErrors = new TreeMap<>();
        for (FieldError field : result.getFieldErrors()) {
            formattedErrors.put(field.getField(), field.getDefaultMessage());
        }
        ValidErrorDto error = new ValidErrorDto(
                "Por favor corregir los siguientes datos: ", formattedErrors, webRequest.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
