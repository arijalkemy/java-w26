package org.example._09blog.Exceptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException() {}

    public AlreadyExistsException(String message) {
        super(message);
    }

}
