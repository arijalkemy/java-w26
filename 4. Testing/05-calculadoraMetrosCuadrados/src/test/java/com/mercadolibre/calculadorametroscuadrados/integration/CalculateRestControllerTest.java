package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    HouseDTO houseDTO;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        houseDTO = new HouseDTO("Duplex", "Holmberg 1100",
                List.of(new RoomDTO("Habitacion", 4, 4),
                        new RoomDTO("Living", 6, 5),
                        new RoomDTO("Cocina", 3, 5)));
    }
        
    @Test
    void calculate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(houseDTO)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value(61))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(48800))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggest.name")
                        .value(houseDTO.getRooms().get(1).getName()));


    }
}
