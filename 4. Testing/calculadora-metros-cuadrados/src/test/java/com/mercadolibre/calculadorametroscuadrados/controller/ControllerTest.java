package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.Writer;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;


    @BeforeAll
    public static void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        writer = objectMapper.writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("Test for the controller calculate")
    public void testCalculate() throws Exception {
        // Arrange (Creation of the DTO to send)
        HouseDTO houseDTO = new HouseDTO("Casa", "Calle 123", List.of(
                new RoomDTO("Sala", 10, 10),
                new RoomDTO("Cocina", 5, 5)
        ));
        // Creation of the expected response
        HouseResponseDTO expectedResponse = new HouseResponseDTO(125,100000,
                new RoomDTO("Sala", 10, 10));
        expectedResponse.setName("Casa");
        expectedResponse.setAddress("Calle 123");
        expectedResponse.setRooms(List.of(
                new RoomDTO("Sala", 10, 10),
                new RoomDTO("Cocina", 5, 5)
        ));

        mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(houseDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(writer.writeValueAsString(expectedResponse)));
    }

}
