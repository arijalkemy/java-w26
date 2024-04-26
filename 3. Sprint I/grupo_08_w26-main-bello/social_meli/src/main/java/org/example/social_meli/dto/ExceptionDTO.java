package org.example.social_meli.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@NoArgsConstructor
public class ExceptionDTO {
    private String message;
    public ExceptionDTO(String message) {
        this.message = message;
    }
}
