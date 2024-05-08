package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class CalculateRestControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    static ObjectMapper mapper;
    static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        mapper = new ObjectMapper();
        writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    }

    @Test
    @DisplayName("Post call to /calculate executes successfully")
    public void calculatePostOkTest() throws Exception {
        // Arrange
        RoomDTO kitchen = new RoomDTO("Kitchen", 10, 10);
        RoomDTO bedroom = new RoomDTO("Bedroom", 5, 5);
        List<RoomDTO> roomDTOList = new ArrayList<>(){{
            add(kitchen);
            add(bedroom);
        }};
        HouseDTO houseDTO = new HouseDTO("Lakehouse", "Maple Road", roomDTOList);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(125);
        expected.setBiggest(kitchen);
        expected.setPrice(100000);

        // Act & Assert
        MvcResult response = this.mockMvc
            .perform(
                MockMvcRequestBuilders.post("/calculate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(writer.writeValueAsString(houseDTO))
            )
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();

        Assertions.assertEquals(writer.writeValueAsString(expected), response.getResponse().getContentAsString());
    }
}
