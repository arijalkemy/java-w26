package org.example.blog.exceptions;

import org.example.blog.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AllReadyExistException.class)
    public ResponseEntity<?> allReadyExists(AllReadyExistException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return new ResponseEntity<>(exceptionDTO,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NonContentException.class)
    public ResponseEntity<?> notContent(NonContentException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO(ex.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NO_CONTENT);
    }
}
