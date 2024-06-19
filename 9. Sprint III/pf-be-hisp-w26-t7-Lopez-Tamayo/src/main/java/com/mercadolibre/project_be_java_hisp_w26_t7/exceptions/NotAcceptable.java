package com.mercadolibre.project_be_java_hisp_w26_t7.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotAcceptable extends RuntimeException {

    public NotAcceptable(String message) {
        super(message);
    }
}
