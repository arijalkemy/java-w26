package com.mercadolibre.calculadorametroscuadrados.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String request;

    @BeforeEach
    void setUp() {
        request = "{\"name\": \"house\", \"address\": \"street 93\", \"rooms\": [" +
                getRoomJson("main room", 5, 5) + "," +
                getRoomJson("second room", 3, 3) + "," +
                getRoomJson("third room", 2, 1) +
                "]}";
    }

    @Test
    @DisplayName("Calculate square meter successful")
    void testCalculateOfficeSuccessful() throws Exception {
        // Arrange
        request = "{\"name\": \"house\", \"address\": \"Street 93\", \"rooms\": [" +
                getRoomJson("second room", 3, 3) + "]}";

        // act and assert
        mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("9")));
    }

    @Test
    void testCalculateTotalPrice() throws Exception {
        // Arrange
        String squareMeterExpected = "36";
        int valuePriceExpected = 28800;

        // act and assert
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(squareMeterExpected)))
                .andExpect(jsonPath("$.price").value(valuePriceExpected));
    }

    @Test
    @DisplayName("Calculate room biggest in the house")
    void testCalculateRoomBiggest() throws Exception {
        // act and assert
        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.biggest.name").value("main room"));
    }

    @Test
    @DisplayName("Calculate the square footage of rooms")
    void testCalculateSquareFootageRooms() throws Exception {

        mockMvc.perform(post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.rooms[0].squareFeet").value(25))
                .andExpect(jsonPath("$.rooms[1].squareFeet").value(9))
                .andExpect(jsonPath("$.rooms[2].squareFeet").value(2));
    }

    private String getRoomJson(String name, int width, int length) {
        return "{\"name\": \"" + name
                + "\", \"width\": " + width
                + ", \"length\": " + length + "}";
    }

}
