package com.w26.blog.controller;

import com.w26.blog.dto.BlogResponse;
import com.w26.blog.exception.CreationBlogException;
import com.w26.blog.exception.GetBlogException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CreationBlogException.class)
    public ResponseEntity<?> handlerCreationBlogException(CreationBlogException exception)
    {
        BlogResponse badResponse = new BlogResponse(exception.getMessage(), null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(badResponse);
    }

    @ExceptionHandler(GetBlogException.class)
    public ResponseEntity<?> handlerGetBlogException(GetBlogException exception)
    {
        BlogResponse badResponse = new BlogResponse(exception.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(badResponse);
    }
}
