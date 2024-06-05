package org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.Util.DataHouse;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseDTO;
import org.meli.ejercicio4_testing_p5_1_calculadorametroscuadrados.dto.HouseResponseDTO;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test de Integración 001 -Reporte vivienda")
    public void calculate() throws Exception {
        //Arrange
        HouseDTO house = DataHouse.getHouseDto();
        HouseResponseDTO houseResponse = DataHouse.getHouseResponseDTO(house);

        ObjectWriter objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String postJson = objectMapper.writeValueAsString(house);
        String postJson2 = objectMapper.writeValueAsString(houseResponse);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(postJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(houseResponse.getSquareFeet())) // Verifica user_id
                .andExpect(jsonPath("$.price").value(houseResponse.getPrice())) // Verifica user_name
                ;
    }

    @Test
    @DisplayName("Test de Integración 002 -Reporte vivienda con datos erroneos")
    public void badcalculate() throws Exception {
        //Arrange
        HouseDTO house = new HouseDTO();

        ObjectWriter objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String postJson = objectMapper.writeValueAsString(house);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(postJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                    ;
    }

}
