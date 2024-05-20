package org.example.g14.exception;


public class UserNotFoundException extends NotFoundException{
    public UserNotFoundException(int id){
        super("El usuario del id " + id + " no existe.");
    }
}
