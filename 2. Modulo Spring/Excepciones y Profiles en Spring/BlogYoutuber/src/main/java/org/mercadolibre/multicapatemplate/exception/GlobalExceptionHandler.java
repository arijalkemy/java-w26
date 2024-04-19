package org.mercadolibre.multicapatemplate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Se le indica a Spring que esta clase sera la encargada de manejar las excepciones globalmente en la app
// Va a manejar aquellas excepciones que se producen desde el controller
// Es equivalente a: @ControllerAdvice( annotations = RestController.class)
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Esto indica en que situacion se va a ejecutar este metodo
    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<?> alreadyExistsException(Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
