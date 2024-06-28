package com.mercadolibre.project_be_java_hisp_w26_t7.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
