package org.implementaciondb.ejercicio5_movies_hql.exception;

public class NoFoundException extends RuntimeException {
    public NoFoundException(String message) {
        super(message);
    }
}
