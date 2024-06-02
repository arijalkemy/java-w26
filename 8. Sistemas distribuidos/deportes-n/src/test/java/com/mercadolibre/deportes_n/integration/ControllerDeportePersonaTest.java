package com.mercadolibre.deportes_n.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerDeportePersonaTest extends ControllerTest {

    @Test
    @DisplayName("Test to get deportes by one person")
    public void verifyGetDeportesAnyPerson() {
        //Arrage
        String systemUnderTest = "/deporte_persona/encontrar";
        
        //Act
        ResponseEntity<?> response = this.testRestTemplate.exchange(systemUnderTest, HttpMethod.GET, getDefaultRequestEntity(), String.class);

        //Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}
