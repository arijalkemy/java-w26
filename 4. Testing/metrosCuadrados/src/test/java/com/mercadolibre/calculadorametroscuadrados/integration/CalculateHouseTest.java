package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateHouseTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;

    static HouseDTO house;
    static HouseResponseDTO response;

    @BeforeAll
    public static void setup() {

        RoomDTO living = new RoomDTO( "Living room", 8, 6 );
        RoomDTO bathroom = new RoomDTO( "Bathroom", 3, 2 );
        RoomDTO room = new RoomDTO( "Room", 5, 4 );
        RoomDTO kitchen = new RoomDTO( "Kitchen", 4, 3 );
        List<RoomDTO> rooms = List.of(living, bathroom, room, kitchen);
        house = new HouseDTO( "House 1", "Sarmiento 3026", rooms );

        response = new HouseResponseDTO();
        response.setName("House 1");
        response.setAddress("Sarmiento 3026");
        response.setRooms(rooms);
        response.setSquareFeet( 86 );
        response.setBiggest(living);
        response.setPrice( 86 * 800);

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @Test
    public void calcularHouseTest() throws Exception {
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(house))
        );

        result.andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet").value(86));

        String contentResponse = result.andReturn().getResponse().getContentAsString();

        String expectedString = writer.writeValueAsString(response);

        Assertions.assertEquals(expectedString, contentResponse);
    }

}
