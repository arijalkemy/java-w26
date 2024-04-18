package org.example.blog.exceptions;

import org.example.blog.exceptions.blog.BlogAlreadyExistException;
import org.example.blog.exceptions.blog.BlogNotFoundExcpetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(BlogAlreadyExistException.class)
        public ResponseEntity<?> BlogRepetido(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(BlogNotFoundExcpetion.class)
    public ResponseEntity<?> BlogNotFound(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
}
