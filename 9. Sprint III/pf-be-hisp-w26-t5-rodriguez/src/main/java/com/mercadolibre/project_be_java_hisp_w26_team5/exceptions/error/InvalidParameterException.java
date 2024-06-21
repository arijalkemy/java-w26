package com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error;

public class InvalidParameterException extends RuntimeException {

    public InvalidParameterException(String param) {
        super("Invalid param: " + param);
    }

}
