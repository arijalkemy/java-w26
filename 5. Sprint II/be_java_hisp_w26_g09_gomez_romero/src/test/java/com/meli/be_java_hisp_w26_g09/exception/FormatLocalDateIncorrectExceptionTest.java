package com.meli.be_java_hisp_w26_g09.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormatLocalDateIncorrectExceptionTest {
    @Test
    public void testConstructor() {
        String errorMessage = "Incorrect format for LocalDate";
        FormatLocalDateIncorrectException exception = new FormatLocalDateIncorrectException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }
}