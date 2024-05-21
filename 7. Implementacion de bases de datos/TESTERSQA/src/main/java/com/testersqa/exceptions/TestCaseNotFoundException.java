package com.testersqa.exceptions;

public class TestCaseNotFoundException extends RuntimeException{
    public TestCaseNotFoundException(String message) {
        super(message);
    }
}
