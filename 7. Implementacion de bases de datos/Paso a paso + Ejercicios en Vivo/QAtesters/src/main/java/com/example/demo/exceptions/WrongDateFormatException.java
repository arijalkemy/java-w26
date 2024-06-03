package com.example.demo.exceptions;

public class WrongDateFormatException extends  RuntimeException{
    public WrongDateFormatException(String message) {
        super(message);
    }
}
