package com.mercadolibre.project_be_java_hisp_w26_t7.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
