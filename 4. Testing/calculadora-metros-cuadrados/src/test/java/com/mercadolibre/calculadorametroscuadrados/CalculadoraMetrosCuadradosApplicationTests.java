package com.mercadolibre.calculadorametroscuadrados;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraMetrosCuadradosApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    public static ObjectWriter writer;
    public static ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    /* public HouseResponseDTO calculate(@RequestBody HouseDTO house){
    CalculateService calculateService = new CalculateService();
    return calculateService.calculate(house);*/
    //verificar que calcule el precio correctamente
    @Test
    void calculatePrice() throws Exception {
        // Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("1");
        houseDTO.setAddress("calle false");
        houseDTO.setRooms(List.of(
                new RoomDTO("cuarto uno", 30, 30),
                new RoomDTO("cuarto dos", 40, 40),
                new RoomDTO("cuarto tres", 20, 20)
        ));

        // Act
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(houseDTO))
        ).andExpect(
                jsonPath("$.name").value("1")
        );

    }


    // a) Se pide, retornar un objeto que diga la cantidad totales de metros cuadrados de la casa.
    @Test
    void calculateHouseWithOneRoom() throws Exception {
        String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
                getRoom("Espacio abierto", 3, 3) +
                "]}";
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("9")));
    }

    @Test
    void calculateHouseWithMultipleRoom() throws Exception {
        String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
                getRoom("Espacio abierto", 5, 5) + "," +
                getRoom("Cocina", 3, 3) + "," +
                getRoom("Baño", 2, 1) +
                "]}";
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("36")));
    }

    //b) Indicar el valor de la casa tomando en cuenta que se toma como referencia USD 800 el metro cuadrado.
    @Test
    void calculateHousePrice() throws Exception {
        String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
                getRoom("Espacio abierto", 5, 5) + "," +
                getRoom("Cocina", 3, 3) + "," +
                getRoom("Baño", 2, 1) +
                "]}";
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("36")))
                .andExpect(jsonPath("$.price").value(28800));
    }

    //c) Retornar el objecto con la habitacion mas grande.
    @Test
    void calculateBiggestRoom() throws Exception {
        String biggestRoom = "Espacio abierto";
        String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
                getRoom(biggestRoom, 5, 5) + "," +
                getRoom("Cocina", 3, 3) + "," +
                getRoom("Baño", 2, 1) +
                "]}";
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.biggest.name").value(biggestRoom));
    }

    //d) Retornar la cantidad de metros cuadrados por habitación.
    @Test
    void calculateRoomsSquareFeet() throws Exception {
        String biggestRoom = "Espacio abierto";
        String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [" +
                getRoom(biggestRoom, 5, 5) + "," +
                getRoom("Cocina", 3, 3) + "," +
                getRoom("Baño", 2, 1) +
                "]}";
        this.mockMvc.perform(
                        post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.rooms[0].squareFeet").value(25))
                .andExpect(jsonPath("$.rooms[1].squareFeet").value(9))
                .andExpect(jsonPath("$.rooms[2].squareFeet").value(2));
    }


    private String getRoom(String name, int width, int length) {
        return "{\"name\": \"" + name + "\", \"width\": " + width + ", \"length\": " + length + "}";
    }

}
