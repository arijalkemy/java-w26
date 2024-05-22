package org.implementaciondb.ejercicio5_movies_hql.controller;

import org.implementaciondb.ejercicio5_movies_hql.exception.NoFoundException;
import org.implementaciondb.ejercicio5_movies_hql.model.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(NoFoundException.class)
    public ResponseEntity<ExceptionDto> handlerNoContentException(NoFoundException ex, WebRequest webRequest) {
        ExceptionDto exdto = new ExceptionDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exdto, HttpStatus.NOT_FOUND);
    }

}
