package org.implementaciondb.vehiculos_siniestros.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
