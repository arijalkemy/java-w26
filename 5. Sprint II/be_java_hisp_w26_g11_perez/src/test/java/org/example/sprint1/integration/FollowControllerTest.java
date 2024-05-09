package org.example.sprint1.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.sprint1.dto.CountFollowersDTO;
import org.example.sprint1.dto.ExceptionDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FollowControllerTest {
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("Verificar que la respuesta sea el id del usuario, el nombre del usuario y la cantidad de seguidores")
    public void countFollowersTest() throws Exception {
        // Arrange
        CountFollowersDTO countFollowersDTO = new CountFollowersDTO(102, "HomeDecor", 4);
        String responseExpected = mapper.writeValueAsString(countFollowersDTO);

        // Act
        MvcResult resultObtained = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 102))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseExpected, resultObtained.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("El usuario no fue encontrado")
    public void countFollowersSellerNotFoundTest() throws Exception {
        // Arrange
        ExceptionDTO exceptionDTO = new ExceptionDTO("Vendedor no encontrado");
        String responseExpected = mapper.writeValueAsString(exceptionDTO);

        // Act
        MvcResult resultObtained = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseExpected, resultObtained.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("El id del usuario debe ser mayor a cero")
    public void invalidUserIdTest() throws Exception {
        // Arrange
        String response = "countFollowers.userId: El id debe ser mayor a cero";

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 0))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(response));
    }
}
