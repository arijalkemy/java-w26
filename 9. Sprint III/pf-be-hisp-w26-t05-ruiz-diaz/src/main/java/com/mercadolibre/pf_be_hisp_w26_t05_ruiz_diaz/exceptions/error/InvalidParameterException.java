package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error;

public class InvalidParameterException extends RuntimeException {

    public InvalidParameterException(String param) {
        super("Invalid param: " + param);
    }

}
