package com.mercadolibre.calculadorametroscuadrados.controller.integration;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import utils.TestUtils;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CalculateRestControllerIntegrationTest {
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectWriter().

    @Test ()
    @DisplayName("Should calculate price successfully when there are no rooms")
    void shouldCalculatePriceSuccessfully() {
        HouseDTO house = TestUtils.createHouseDTO(new ArrayList<>());


//        MvcResult mvcResult = mockMvc.perform(get("/calculate"))
    }
}
