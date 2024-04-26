package org.mercadolibre.NotNullTeam.exception.error;

import lombok.Data;

@Data
public class PostAlreadyIsFavoriteExceptionDTO extends RuntimeException{
    public PostAlreadyIsFavoriteExceptionDTO(String message) {
        super(message);
    }
}
