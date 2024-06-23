package com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
