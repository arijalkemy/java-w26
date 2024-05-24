package com.prendaselastic.exceptions;

public class PrendaNotFoundException extends RuntimeException{

        public PrendaNotFoundException(String message) {
            super(message);
        }
}
