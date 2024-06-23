package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("not found");
    }

    public NotFoundException(String entity) {
        super(entity + " not found");
    }

    public NotFoundException(String entity, String param) {
        super(entity + " not found >> " + param);
    }
}
