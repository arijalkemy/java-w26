package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.utils.TestHouseGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculateRestController.class)
class CalculateRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculateService calculateService;

    private static ObjectWriter writer;

    @BeforeEach
    void setUp() {
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }

    @Test
    void calculate() throws Exception {
        // Arrange
        HouseDTO house = TestHouseGenerator.getHouseDTOWithRooms();
        HouseResponseDTO houseResponseDTO = TestHouseGenerator.getHouseResponseDTOWithRooms();
        String houseExpected = writer.writeValueAsString(houseResponseDTO);
        when(calculateService.calculate(house)).thenReturn(houseResponseDTO);
        // Act
        ResultActions response = mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(house))
        );
        // Assert
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(
                            houseExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8)
                        )
                );
    }
}