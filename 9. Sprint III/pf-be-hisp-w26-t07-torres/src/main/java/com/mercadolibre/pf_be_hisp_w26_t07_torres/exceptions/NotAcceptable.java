package com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotAcceptable extends RuntimeException {

    public NotAcceptable(String message) {
        super(message);
    }
}
