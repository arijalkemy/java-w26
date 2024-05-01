package com.meli.obtenerdiploma.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ErrorResponseDto {
    LocalDateTime timestamp;
    Integer status;
    HttpStatus error;
    String message;
    String path;
    List<ValidationErrorDto> validations;
}
