package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
    }

    public ForbiddenException(String message) {
        super(message);
    }
}
