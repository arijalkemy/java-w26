package org.example.integradorlinktracker.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> conflict(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body((e.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((e.getMessage()));
    }

}
