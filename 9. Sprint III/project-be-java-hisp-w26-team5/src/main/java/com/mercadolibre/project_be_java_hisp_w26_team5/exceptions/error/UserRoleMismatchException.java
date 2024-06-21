package com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error;

public class UserRoleMismatchException extends RuntimeException {
    public UserRoleMismatchException(String expectedRole) {
        super("Expected user with role: " + expectedRole);
    }
}