package com.example.showroom.exceptions;

import com.example.showroom.model.dto.ErrorMsgDto;
import com.example.showroom.model.dto.InfoMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ShowroomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMsgDto> notFound(NotFoundException ex, WebRequest webRequest) {
        ErrorMsgDto infoMessageDto = new ErrorMsgDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(infoMessageDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMsgDto> badRequest(BadRequestException ex, WebRequest webRequest) {
        ErrorMsgDto infoMessageDto = new ErrorMsgDto(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(infoMessageDto, HttpStatus.BAD_REQUEST);
    }
}
