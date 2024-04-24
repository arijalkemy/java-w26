package org.example.blog.exception;

import org.example.blog.dto.MensajeRespuestaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntradaBlogNoEncontradaException.class)
    public ResponseEntity<?> handleEntradaBlogNoEncontrada(Exception e) {
        return new ResponseEntity<>(new MensajeRespuestaDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntradaBlogYaExiste.class)
    public ResponseEntity<?> handleEntradaBlogYaExiste(Exception e) {
        return ResponseEntity.badRequest().body(new MensajeRespuestaDto(e.getMessage()));
    }
}
