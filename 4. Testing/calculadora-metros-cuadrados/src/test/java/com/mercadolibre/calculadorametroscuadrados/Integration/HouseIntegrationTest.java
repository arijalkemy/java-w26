package com.mercadolibre.calculadorametroscuadrados.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class HouseIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;


    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();

    }



    @Test
    public void testCalculate() throws Exception {

        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room = new RoomDTO();
        room.setName("Habitacion Ejemplo"); // Establecer el nombre de la habitación
        room.setWidth(10); // Establecer el ancho de la habitación
        room.setLength(20); // Establecer la longitud de la habitación
        rooms.add(room); // Añadir la habitación a la lista de habitaciones
        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitacion Ejemplo 2"); // Establecer el nombre de la habitación
        room2.setWidth(5); // Establecer el ancho de la habitación
        room2.setLength(10); // Establecer la longitud de la habitación
        rooms.add(room2);

        HouseDTO house = new HouseDTO();
        house.setName("Casa Ejemplo"); // Establecer el nombre de la casa
        house.setAddress("Direccion Ejemplo"); // Establecer la dirección de la casa
        house.setRooms(rooms); // Establecer las habitaciones de la casa


        String houseJson = objectMapper.writeValueAsString(house);
        ResultActions response =  mockMvc.perform(MockMvcRequestBuilders.post("/calculate" , house)
                .contentType("application/json")
                .content(houseJson));


        response.andDo(print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        MvcResult mvcResult = response.andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();
        HouseDTO houseResponse = objectMapper.readValue(responseBody, HouseDTO.class);


        assertEquals(houseResponse.getName() , house.getName());
        assertEquals(houseResponse.getAddress() , house.getAddress());
        assertEquals(houseResponse.getRooms().size() , house.getRooms().size());
        assertEquals(houseResponse.getRooms().get(0).getName() , room.getName());
        assertEquals(houseResponse.getRooms().get(1).getName() , room2.getName());
        assertEquals(houseResponse.getRooms().get(0).getSquareFeet() , room.getSquareFeet());
        assertEquals(houseResponse.getRooms().get(1).getSquareFeet() , room2.getSquareFeet());

    }



}
