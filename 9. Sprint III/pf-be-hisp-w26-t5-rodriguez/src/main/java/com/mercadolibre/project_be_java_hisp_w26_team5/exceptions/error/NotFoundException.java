package com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error;

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
