package com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
