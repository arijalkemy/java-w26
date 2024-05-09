package org.example.social_meli.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@NoArgsConstructor
@Builder
public class ExceptionDTO {
    private String message;
    public ExceptionDTO(String message) {
        this.message = message;
    }
}
