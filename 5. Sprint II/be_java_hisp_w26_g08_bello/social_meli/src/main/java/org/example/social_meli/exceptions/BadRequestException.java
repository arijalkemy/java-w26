package org.example.social_meli.exceptions;

public class BadRequestException extends RuntimeException {
    private final String error_code;
    private final String details;

    // Constructor completo que inicializa todos los campos
    public BadRequestException(String message, String error_code, String details) {
        super(message);
        this.error_code = error_code;
        this.details = details;
    }

    // Constructor simplificado que solo inicializa el mensaje
    public BadRequestException(String message) {
        super(message);
        this.error_code = null;  // Valor predeterminado
        this.details = null;     // Valor predeterminado
    }

    // Métodos getter para acceder a los campos privados
    public String getError_code() {
        return error_code;
    }

    public String getDetails() {
        return details;
    }
}


