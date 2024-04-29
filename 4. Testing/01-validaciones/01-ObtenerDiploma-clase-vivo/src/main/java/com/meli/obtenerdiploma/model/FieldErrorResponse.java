package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.FieldError;

@Data
@AllArgsConstructor
public class FieldErrorResponse {
    private String field;
    private String message;

    public static FieldErrorResponse ofError(FieldError error){
        return new FieldErrorResponse(error.getField(), error.getDefaultMessage());
    }
}
