package org.example.productos.exceptions;

public class NotFoundException  extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
