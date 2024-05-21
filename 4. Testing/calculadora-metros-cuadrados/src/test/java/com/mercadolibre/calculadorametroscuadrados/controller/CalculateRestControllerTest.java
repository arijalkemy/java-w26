package com.mercadolibre.calculadorametroscuadrados.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should calculate the square meters of a house")
    void calculate() throws Exception {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Casa 1");
        houseDTO.setAddress("Calle 1");
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Habitacion 1");
        roomDTO.setWidth(10);
        roomDTO.setLength(10);
        houseDTO.setRooms(List.of(roomDTO));

        mockMvc.perform(post("/calculate")
                .contentType("application/json")
                .content(new ObjectMapper().writeValueAsString(houseDTO)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Casa 1"))
            .andExpect(jsonPath("$.squareFeet").value(100))
            .andExpect(jsonPath("$.price").value(80000));
    }
}