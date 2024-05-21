package org.example.es_hib_empleados.exceptions;

import org.example.es_hib_empleados.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class EmpleadosExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFound(NotFoundException ex, WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
