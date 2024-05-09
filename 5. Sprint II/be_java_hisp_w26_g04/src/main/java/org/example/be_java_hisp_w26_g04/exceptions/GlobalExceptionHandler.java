package org.example.be_java_hisp_w26_g04.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.example.be_java_hisp_w26_g04.dto.BadResponseDTO;
import org.example.be_java_hisp_w26_g04.dto.ValidationErrorsResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<?> badRequest() {
    return ResponseEntity.badRequest().build();
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<BadResponseDTO> handleNotFoundException(NotFoundException ex) {
    BadResponseDTO badResponseDto = new BadResponseDTO(
        ex.getMessage(), HttpStatus.NOT_FOUND.value()
    );

    return new ResponseEntity<>(badResponseDto, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErrorsResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errorMap = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
      errorMap.put(error.getField(), error.getDefaultMessage());
    });

    ValidationErrorsResponseDTO errorsResponseDTO =
            new ValidationErrorsResponseDTO("Hay errores de validación", errorMap);

    return ResponseEntity.badRequest().body(errorsResponseDTO);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ValidationErrorsResponseDTO> handleValidationConstraintExceptions(ConstraintViolationException ex) {
    Map<String, String> errorMap = new HashMap<>();
    ex.getConstraintViolations().forEach(error -> {
      errorMap.put(error.getPropertyPath().toString(), error.getMessage());
    });

    ValidationErrorsResponseDTO errorsResponseDTO =
            new ValidationErrorsResponseDTO("Hay errores de validación", errorMap);

    return ResponseEntity.badRequest().body(errorsResponseDTO);
  }
}
