package com.w26.linktracker.exception;

import com.w26.linktracker.dto.LinkMetricsCalls;
import com.w26.linktracker.dto.LinkResultCreation;
import com.w26.linktracker.repository.LinkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceController {

    @ExceptionHandler(CreationLinkException.class)
    public ResponseEntity<?> handlerCreationLinkException(CreationLinkException exception)
    {
        LinkResultCreation result = new LinkResultCreation(exception.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @ExceptionHandler(RetriveLinkException.class)
    public ResponseEntity<?> handlerRetriveLinkException(RetriveLinkException exception)
    {
        LinkMetricsCalls badResult = new LinkMetricsCalls(exception.getIdToRetrive(), null, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badResult);
    }

    @ExceptionHandler(RedirectionLinkException.class)
    public ResponseEntity<?> handlerRedirectionLinkException(RedirectionLinkException exception)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Investigar Redirect");
    }



}
