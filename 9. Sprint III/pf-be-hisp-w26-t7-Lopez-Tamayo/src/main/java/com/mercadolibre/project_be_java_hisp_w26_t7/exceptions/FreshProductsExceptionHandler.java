package com.mercadolibre.project_be_java_hisp_w26_t7.exceptions;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.errors.ExceptionDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.errors.ValidErrorDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice
public class FreshProductsExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handlerNotFound(NotFoundException ex, WebRequest webRequest) {
        ExceptionDto exdto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDto> handlerBadRequest(BadRequestException ex, WebRequest webRequest) {
        ExceptionDto exdto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotAcceptable.class)
    public ResponseEntity<ExceptionDto> handlerNotAcceptable(NotAcceptable ex, WebRequest webRequest) {
        return new ResponseEntity<>(
                new ExceptionDto(ex.getMessage(), webRequest.getDescription(false)),
                HttpStatus.NOT_ACCEPTABLE
        );
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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidErrorDto> handlerConstraintViolationException(
            ConstraintViolationException ex,
            WebRequest webRequest
    ) throws Exception {
        Map<String, String> formattedErrors = new TreeMap<>();
        ex.getConstraintViolations().forEach(violation ->
                formattedErrors.put(violation.getPropertyPath().toString(), violation.getMessage()));
        ValidErrorDto error = new ValidErrorDto(
                "Por favor corregir los siguientes datos: ", formattedErrors, webRequest.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ExceptionDto> handlerMethodValidation(
            HandlerMethodValidationException ex, WebRequest webRequest
    ) {
        ExceptionDto exDto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ExceptionDto> handlerNumberFormatException(NumberFormatException ex, WebRequest webRequest) {
        ExceptionDto exDto = new ExceptionDto(
                "El valor ingresado no cumple con un formato adecuado",
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(exDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDto> handlerHttpMessageNotReadableException(
            HttpMessageNotReadableException ex, WebRequest webRequest
    ) {
        ExceptionDto exDto = new ExceptionDto(
                "Formano no valido",
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(exDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ExceptionDto> handlerJwtException(JwtException ex, WebRequest webRequest) {
        ExceptionDto exDto = new ExceptionDto(
                ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exDto, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionDto> handlerAccessDenied(AccessDeniedException ex, WebRequest webRequest) {
        ExceptionDto exDto = new ExceptionDto(
                ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exDto, HttpStatus.UNAUTHORIZED);
    }
}
