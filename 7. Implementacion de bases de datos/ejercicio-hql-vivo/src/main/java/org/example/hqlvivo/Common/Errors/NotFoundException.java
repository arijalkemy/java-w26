package org.example.hqlvivo.Common.Errors;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("not found");
    }
}
