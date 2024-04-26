package org.mercadolibre.NotNullTeam.exception.error;

public class UserAlreadyFollowedException extends RuntimeException{

    public UserAlreadyFollowedException(String message) {
        super(message);
    }
}
