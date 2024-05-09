package org.example.g14.exception;

public class NotSellerException extends BadRequestException{
    public NotSellerException(int id){
        super("El usuario del id " + id + " no es un vendedor.");
    }
}
