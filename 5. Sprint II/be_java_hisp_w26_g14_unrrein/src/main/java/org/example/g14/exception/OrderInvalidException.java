package org.example.g14.exception;

public class OrderInvalidException extends BadRequestException{
    public OrderInvalidException(String order){
        super("El ordenamiento: " + order + " es invalido.");
    }
}
