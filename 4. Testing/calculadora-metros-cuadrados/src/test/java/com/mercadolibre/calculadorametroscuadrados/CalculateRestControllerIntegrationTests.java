package com.mercadolibre.calculadorametroscuadrados;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    private HouseDTO houseDTO;
    private RoomDTO largestRoomDTO;
    private RoomDTO smallestRoomDTO;
    private RoomDTO emptyRoomDTO = new RoomDTO();

    private String payload;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        largestRoomDTO = new RoomDTO();
        largestRoomDTO.setLength(100);
        largestRoomDTO.setWidth(100);
        largestRoomDTO.setName("Largest Room");

        smallestRoomDTO = new RoomDTO();
        smallestRoomDTO.setLength(5);
        smallestRoomDTO.setWidth(5);
        smallestRoomDTO.setName("Smallest Room");

        houseDTO = new HouseDTO();
        houseDTO.setAddress("Av. Siempreviva 123");
        houseDTO.setName("Casa");
        houseDTO.setRooms(List.of(smallestRoomDTO, largestRoomDTO, emptyRoomDTO));

        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        payload = objectWriter.writeValueAsString(houseDTO);
    }

    @Test
    public void calculationTest() throws Exception {
        Integer squareFeet = largestRoomDTO.getSquareFeet() + smallestRoomDTO.getSquareFeet();
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value(squareFeet))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(squareFeet * 800));
    }
}
