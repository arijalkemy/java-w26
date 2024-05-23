package com.mercadolibre.testcases.exception;

public class TestCaseNotFoundException extends RuntimeException {
    public TestCaseNotFoundException() {
    }

    public TestCaseNotFoundException(String message) {
        super(message);
    }
}
