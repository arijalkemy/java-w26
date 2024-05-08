package org.example.social_meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@NoArgsConstructor
public class ExceptionDTO {
    private String message;
    //private String error_code;
    //private String details;
    public ExceptionDTO(String message) {
        this.message = message;
    }
}
