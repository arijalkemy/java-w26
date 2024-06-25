package com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
