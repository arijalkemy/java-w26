package com.meli.ejercicioenvivovehiculo.exception;

import com.meli.ejercicioenvivovehiculo.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(VehiculeNotFound.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(e.getMessage(),HttpStatus.NOT_FOUND.value()));
    }


    @ExceptionHandler(VehiculeExist.class)
    public ResponseEntity<?> vehiculeExist(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseDTO(e.getMessage(),HttpStatus.CONFLICT.value()));
    }
}
