package com.blog.excercise.excpetion;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
    }

    public BadRequestException(String message) {super(message);}
}
