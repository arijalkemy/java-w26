package com.mercadolibre.deportes_n.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerDeporteTest extends ControllerTest {

    @Test
    @DisplayName("Test to verify succesfully get deportes when nombre is null")
    public void verifyGetDeportesNullNombre() {
        //Arrange and act
        ResponseEntity<String> response = this.testRestTemplate.exchange("/deporte/encontrarDeportes/", HttpMethod.GET, this.getDefaultRequestEntity(), String.class);
        
        //Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }


    @Test
    @DisplayName("Test to verify succesfully get deportes when nombre is Baloncest")
    public void verifyGetDeportesNotNullNombre() {
        //Arrange
        String nombreDeporte = "Baloncesto";
        String systemUnderTest = "/deporte/encontrarDeportes/" + nombreDeporte;
        //Act
        ResponseEntity<String> response = this.testRestTemplate.exchange(systemUnderTest, HttpMethod.GET, this.getDefaultRequestEntity(), String.class);
        
        //Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode()); 
    }


    @Test
    @DisplayName("Test to verify succesfully get deportes when nombre is None")
    public void verifyGetDeportesNotExistNombrre() {
        //Arrange
        String nombreDeporte = "None";
        String systemUnderTest = "/deporte/encontrarDeportes/" + nombreDeporte;
        //Act
        ResponseEntity<String> response = this.testRestTemplate.exchange(systemUnderTest, HttpMethod.GET, this.getDefaultRequestEntity(), String.class);
        
        //Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode()); 
    }
}
