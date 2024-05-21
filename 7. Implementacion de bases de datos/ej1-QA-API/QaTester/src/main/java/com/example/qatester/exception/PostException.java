package com.example.qatester.exception;

import com.example.qatester.dto.ErrorDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PostException extends RuntimeException{

    private final ErrorDto error;
    private final HttpStatus status;

    public PostException(String message, HttpStatus status) {
        this.error = new ErrorDto(this.getClass().getSimpleName(), message);
        this.status = status;
    }
}
