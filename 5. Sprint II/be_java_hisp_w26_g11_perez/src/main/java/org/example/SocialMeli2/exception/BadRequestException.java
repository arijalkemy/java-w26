package org.example.SocialMeli2.exception;

/**
 * Excepción personalizada que se lanza cuando se recibe una solicitud incorrecta.
 */
public class BadRequestException extends RuntimeException{

    /**
     * Constructor de la excepción.
     *
     * @param message El mensaje de la excepción.
     */
    public BadRequestException(String message) {
        super(message);
    }
}
