package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.exceptions;

public class NotAcceptable extends RuntimeException {
    public NotAcceptable() {

    }

    public NotAcceptable(String message) {
        super(message);
    }
}
