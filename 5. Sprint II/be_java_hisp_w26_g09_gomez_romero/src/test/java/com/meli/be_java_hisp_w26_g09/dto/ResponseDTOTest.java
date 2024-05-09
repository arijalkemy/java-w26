package com.meli.be_java_hisp_w26_g09.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseDTOTest {
    @Test
    @DisplayName("Test constructor and getters")
    void testConstructorAndGetters() {
        String message = "Test message";

        ResponseDTO responseDTO = new ResponseDTO(message);

        assertEquals(message, responseDTO.getMessage());
    }

    @Test
    @DisplayName("Test equals and hashCode")
    void testEqualsAndHashCode() {
        ResponseDTO responseDTO1 = new ResponseDTO("Test");
        ResponseDTO responseDTO2 = new ResponseDTO("Test");

        assertEquals(responseDTO1, responseDTO2);
        assertEquals(responseDTO1.hashCode(), responseDTO2.hashCode());
    }

    @Test
    @DisplayName("Test toString")
    void testToString() {
        String message = "Test message";

        ResponseDTO responseDTO = new ResponseDTO(message);

        assertEquals("ResponseDTO(message=" + message + ")", responseDTO.toString());
    }

    @Test
    @DisplayName("Test setter")
    void testSetter() {
        ResponseDTO responseDTO = new ResponseDTO("Initial message");
        String newMessage = "New message";

        responseDTO.setMessage(newMessage);

        assertEquals(newMessage, responseDTO.getMessage());
    }
}