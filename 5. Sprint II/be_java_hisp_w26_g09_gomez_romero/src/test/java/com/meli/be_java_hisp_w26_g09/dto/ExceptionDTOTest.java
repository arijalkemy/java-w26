package com.meli.be_java_hisp_w26_g09.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.FieldError;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionDTOTest {
    @Test
    @DisplayName("Test AllArgsConstructor")
    void testAllArgsConstructor() {
        String field = "testField";
        String message = "testMessage";

        ExceptionDTO exceptionDTO = new ExceptionDTO(field, message);

        assertEquals(field, exceptionDTO.getField());
        assertEquals(message, exceptionDTO.getMessage());
    }

    @Test
    @DisplayName("Test NoArgsConstructor")
    void testNoArgsConstructor() {
        ExceptionDTO exceptionDTO = new ExceptionDTO();

        assertEquals(null, exceptionDTO.getField());
        assertEquals(null, exceptionDTO.getMessage());
    }

    @Test
    @DisplayName("Test ofError")
    void testOfError() {
        String field = "testField";
        String message = "testMessage";
        FieldError fieldError = new FieldError("objectName", field, message);

        ExceptionDTO exceptionDTO = ExceptionDTO.ofError(fieldError);

        assertEquals(field, exceptionDTO.getField());
        assertEquals(message, exceptionDTO.getMessage());
    }

    @Test
    @DisplayName("Test SingleArgConstructor")
    void testSingleArgConstructor() {
        String message = "testMessage";

        ExceptionDTO exceptionDTO = new ExceptionDTO(message);

        assertEquals(null, exceptionDTO.getField());
        assertEquals(message, exceptionDTO.getMessage());
    }

    @Test
    @DisplayName("Test EqualsAndHashCode")
    void testEqualsAndHashCode() {
        ExceptionDTO exceptionDTO1 = new ExceptionDTO("field1", "message1");
        ExceptionDTO exceptionDTO2 = new ExceptionDTO("field1", "message1");
        ExceptionDTO exceptionDTO3 = new ExceptionDTO("field2", "message2");

        assertEquals(exceptionDTO1, exceptionDTO2);
        assertEquals(exceptionDTO1.hashCode(), exceptionDTO2.hashCode());
        assertNotEquals(exceptionDTO1, exceptionDTO3);
        assertNotEquals(exceptionDTO1.hashCode(), exceptionDTO3.hashCode());
    }

    @Test
    @DisplayName("Test ToString")
    void testToString() {
        String field = "testField";
        String message = "testMessage";
        ExceptionDTO exceptionDTO = new ExceptionDTO(field, message);

        String expectedToString = "ExceptionDTO(field=" + field + ", message=" + message + ")";

        assertEquals(expectedToString, exceptionDTO.toString());
    }
}