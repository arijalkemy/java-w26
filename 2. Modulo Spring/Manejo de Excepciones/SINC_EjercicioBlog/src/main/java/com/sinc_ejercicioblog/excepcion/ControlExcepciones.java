package com.sinc_ejercicioblog.excepcion;

import com.sinc_ejercicioblog.controlador.EntradaBlogControlador;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)
public class ControlExcepciones {

    @ExceptionHandler(IdBlogExistente.class)
    public ResponseEntity<?>IdBlogExistente(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(IdBlogInexistente.class)
    public ResponseEntity<?>IdBlogInexistente(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
