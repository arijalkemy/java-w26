package meli.bootcamp.star_wars.exception;

import meli.bootcamp.star_wars.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException e) {
    ExceptionDto response = new ExceptionDto(e.getMessage(), HttpStatus.NOT_FOUND.value());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DuplicatedIdException.class)
  public ResponseEntity<ExceptionDto> handleNotFoundException(DuplicatedIdException e) {
    ExceptionDto response = new ExceptionDto(e.getMessage(), HttpStatus.CONFLICT.value());
    return new ResponseEntity<>(response, HttpStatus.CONFLICT);
  }
}
