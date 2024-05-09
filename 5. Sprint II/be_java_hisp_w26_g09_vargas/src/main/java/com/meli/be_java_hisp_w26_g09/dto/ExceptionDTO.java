package com.meli.be_java_hisp_w26_g09.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.FieldError;


import jakarta.validation.constraints.Null;

@AllArgsConstructor
@Getter
public class ExceptionDTO {
    
    @Null
    private String field;

    private String message;

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public static ExceptionDTO ofError(FieldError error){
        return new ExceptionDTO(error.getField(), error.getDefaultMessage());
    }
}
