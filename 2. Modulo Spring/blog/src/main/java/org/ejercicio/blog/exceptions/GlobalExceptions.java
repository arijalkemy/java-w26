package org.ejercicio.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptions {

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<?> handleBlogNotFoundException(BlogNotFoundException e) {
        //Aquí podría ir un logger que guarde el mensaje del error
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<?> handleBlogAlreadyExistsException(BlogAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
