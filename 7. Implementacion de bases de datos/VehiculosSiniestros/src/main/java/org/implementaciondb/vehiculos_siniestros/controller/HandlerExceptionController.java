package org.implementaciondb.vehiculos_siniestros.controller;

import org.implementaciondb.vehiculos_siniestros.exception.NotFoundException;
import org.implementaciondb.vehiculos_siniestros.model.dto.error.ExceptionDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.error.ValidErrorDto;
import org.springframework.dao.DataIntegrityViolationException;
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
public class HandlerExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handlerNoContentException(NotFoundException ex, WebRequest webRequest) {
        ExceptionDto exdto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.NOT_FOUND);
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

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDto> handlerDataIntegrityViolationException(
            DataIntegrityViolationException ex, WebRequest webRequest
    ) {
        ExceptionDto exdto = new ExceptionDto(
                "Error de integridad", webRequest.getDescription(false)
        );
        return new ResponseEntity<>(exdto, HttpStatus.BAD_REQUEST);
    }

}
