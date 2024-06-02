package org.example.spring_demo.exception;

public class NumberNotValid extends RuntimeException {
    public NumberNotValid(String message) {
        super(message);
    }
}
