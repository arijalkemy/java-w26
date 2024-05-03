package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ValidErrorDTO;
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
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidErrorDTO> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, WebRequest webRequest
    ) {
        BindingResult result = ex.getBindingResult();
        Map<String, String> formattedErrors = new TreeMap<>();
        for (FieldError field : result.getFieldErrors()) {
            formattedErrors.put(field.getField(), field.getDefaultMessage());
        }
        ValidErrorDTO error = new ValidErrorDTO(
                "Por favor corregir los siguientes datos: ", formattedErrors, webRequest.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
