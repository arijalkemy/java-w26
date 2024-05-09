package org.example.SocialMeli2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para manejar las excepciones.
 * Este DTO se utiliza para representar la información de una excepción.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO {
    /**
     * El mensaje de la excepción.
     */
    private String message;
}
