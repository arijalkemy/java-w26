package com.meli.be_java_hisp_w26_g09.exception;

public class NullEntityException extends RuntimeException{

    public NullEntityException(String entity) {
        super("The " + entity + "Entity cann't be null or empty.");
    }
}
