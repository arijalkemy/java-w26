package org.example.linktracker.exception;

public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException() {
        super("No existe un Link con el ID especificado, o el mismo fue invalidado");
    }
}
