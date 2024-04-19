package org.example.blog.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(BlogException.class)
    public ResponseEntity<String> handleBlogException(BlogException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
