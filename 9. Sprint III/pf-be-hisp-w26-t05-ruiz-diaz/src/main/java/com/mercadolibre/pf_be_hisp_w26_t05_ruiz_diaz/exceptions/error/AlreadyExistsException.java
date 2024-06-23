package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
