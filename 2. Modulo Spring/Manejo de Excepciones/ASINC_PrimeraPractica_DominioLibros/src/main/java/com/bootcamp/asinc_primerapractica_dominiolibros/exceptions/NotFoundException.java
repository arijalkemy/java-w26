package com.bootcamp.asinc_primerapractica_dominiolibros.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
    }

    public NotFoundException (String message) {
        super(message);
    }
}
