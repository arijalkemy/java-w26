package org.example.be_java_hisp_w26_g04.service.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;
import java.util.Map;
import org.example.be_java_hisp_w26_g04.dto.BuyerDTO;
import org.example.be_java_hisp_w26_g04.dto.UserDTO;
import org.example.be_java_hisp_w26_g04.dto.ValidationErrorsResponseDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        ObjectMapper objectMapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        writer = objectMapper.writer();
    }

    @Test
    @DisplayName("cannot GET list of followed sellers with an invalid buyer id")
    public void sortFollowedFails() throws Exception {
        // Arrange
        int userId = 0;
        String order = "name_asc";

        ValidationErrorsResponseDTO expected = new ValidationErrorsResponseDTO(
            "Hay errores de validacion",
            Map.of("sortFollowed.userId", "El ID debe ser mayor a cero.")
        );

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .get("/users/{userId}/followed/list", userId)
            .param("order", order);

        // Act & Assert
        MvcResult result = this.mockMvc.perform(request)
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();

        // Assert
        String expectedContent = writer.writeValueAsString(expected);
        String resultContent = result.getResponse().getContentAsString();

        assertEquals(expectedContent, resultContent);
    }

    @Test
    @DisplayName("GET list of followed sellers by a buyer - DESC")
    public void sortFollowedDesc() throws Exception {
        // Arrange
        int userId = 456;
        String order = "name_desc";
        String username = "JaneDoe";

        List<UserDTO> following = List.of(
            new UserDTO(123, "JohnDoe"),
            new UserDTO(234, "JaneSmith")
        );

        BuyerDTO expected = new BuyerDTO(userId, username, following);

        // Act & Assert
        performRequest(userId, expected, order);
    }

    @Test
    @DisplayName("GET list of followed sellers by a buyer - ASC")
    public void sortFollowedAsc() throws Exception {
        // Arrange
        int userId = 456;
        String order = "name_asc";
        String username = "JaneDoe";

        List<UserDTO> following = List.of(
            new UserDTO(234, "JaneSmith"),
            new UserDTO(123, "JohnDoe")
        );

        BuyerDTO expected = new BuyerDTO(userId, username, following);

        // Act & Assert
        performRequest(userId, expected, order);
    }

    public void performRequest(int userId, BuyerDTO expected, String order) throws Exception {
        // Arrange
        String expectedContent = writer.writeValueAsString(expected);

        // Arrange
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .get("/users/{userId}/followed/list", userId)
            .param("order", order);

        // Act & Assert
        MvcResult result = this.mockMvc.perform(request)
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();

        // Assert
        String resultContent = result.getResponse().getContentAsString();
        assertEquals(expectedContent, resultContent);
    }
}
