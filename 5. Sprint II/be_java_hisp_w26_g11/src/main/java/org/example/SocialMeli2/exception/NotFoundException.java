package org.example.SocialMeli2.exception;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un recurso solicitado.
 */
public class NotFoundException extends RuntimeException{

    /**
     * Constructor de la excepción.
     *
     * @param message El mensaje de la excepción.
     */
    public NotFoundException(String message) {
        super(message);
    }
}
