package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        MultiValueMap<String, String> detail = new LinkedMultiValueMap<>();

        for (FieldError error : e.getFieldErrors()) {
            detail.add(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(new ErrorDTO(
            "Hubo algún error de validación en los datos de la petición",
            detail
        ));
    }
}
