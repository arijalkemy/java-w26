package org.example.obtenerdiploma.exception.error;

public class UserAlreadyFollowedException extends RuntimeException{

        public UserAlreadyFollowedException() {
            super("User already followed");
        }
}
