package org.bootcamp.manejo_de_excepciones_p1_blog.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {
    @ExceptionHandler(ExistingResourceException.class)
    public ResponseEntity<?> handleExistingResourceException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(NonExistentResourceException.class)
    public ResponseEntity<?> handleNonExistentResourceException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
