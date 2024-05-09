package com.meli.be_java_hisp_w26_g09.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionDTO {
    private String field;
    private String message;

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public static ExceptionDTO ofError(FieldError error){
        return new ExceptionDTO(error.getField(), error.getDefaultMessage());
    }
}
