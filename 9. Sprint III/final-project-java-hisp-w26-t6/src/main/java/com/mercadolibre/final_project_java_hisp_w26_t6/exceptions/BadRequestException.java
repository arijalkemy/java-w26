package com.mercadolibre.final_project_java_hisp_w26_t6.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
