package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error;

public class UserRoleMismatchException extends RuntimeException {
    public UserRoleMismatchException(String expectedRole) {
        super("Expected user with role: " + expectedRole);
    }
}