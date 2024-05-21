package com.testersqa.controllers;

import com.testersqa.exceptions.TestCaseNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TestCaseNotFoundException.class)
    public String handleTestCaseNotFoundException(TestCaseNotFoundException ex) {
        return ex.getMessage();
    }
}
