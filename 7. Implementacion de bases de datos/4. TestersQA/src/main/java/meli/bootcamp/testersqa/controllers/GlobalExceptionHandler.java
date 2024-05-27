package meli.bootcamp.testersqa.controllers;

import meli.bootcamp.testersqa.exceptions.TestCaseNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TestCaseNotFoundException.class)
    public String handleTestCaseNotFoundException(TestCaseNotFoundException ex) {
        return ex.getMessage();
    }
}
