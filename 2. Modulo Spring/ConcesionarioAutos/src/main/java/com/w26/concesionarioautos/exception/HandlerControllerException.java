package com.w26.concesionarioautos.exception;

import com.w26.concesionarioautos.dto.CarServices;
import com.w26.concesionarioautos.dto.GetCarServicesResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class HandlerControllerException {

    @ExceptionHandler(NotFoundCarByFilterException.class)
    public ResponseEntity<?> handlerNotFoundCarByFilter(NotFoundCarByFilterException exception)
    {
        GetCarServicesResult result = new GetCarServicesResult(exception.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }
}
