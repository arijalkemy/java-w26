package com.demospring.joyerialasperlas.exception;

public class NotFoundException extends RuntimeException{
        public NotFoundException(String entity, Long param) {
            super("Object " + entity + " not found >> id: " + param);
        }
}
