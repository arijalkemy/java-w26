package com.calculadora.calorias.Exception;
import com.calculadora.calorias.Dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(DishNotFoundException.class)
    public ResponseEntity<?> notFound(DishNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}

