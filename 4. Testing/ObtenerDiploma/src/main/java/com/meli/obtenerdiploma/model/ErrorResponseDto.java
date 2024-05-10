package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ErrorResponseDto {

    private LocalDateTime timestamp;
    private int status;
    private Map<String, String> errors;
    private String error;
    private String message;
    private String path;

}

