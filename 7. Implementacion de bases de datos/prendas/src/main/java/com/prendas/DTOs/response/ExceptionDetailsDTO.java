package com.prendas.DTOs.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExceptionDetailsDTO {
    private String message;

    public ExceptionDetailsDTO(String message) {
        this.message = message;
    }
}
