package org.example.g14.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("integración: obtener lista de seguidores con orden ascendente")
    public void testGetFollowersListNameAsc() throws Exception {
        // Arrange
        int userId = 1;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                        .param("order", "name_asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_name").value("John Doe"))
                .andExpect(jsonPath("$.followers[0].user_name").value("Emily Brown"))
                .andExpect(jsonPath("$.followers[1].user_name").value("Jane Smith"))
                .andExpect(jsonPath("$.followers[2].user_name").value("Michael Johnson"));
    }

    @Test
    @DisplayName("integración: obtener lista de seguidores con orden descendente")
    public void testGetFollowersListNameDesc() throws Exception {
        // Arrange
        int userId = 1;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                        .param("order", "name_desc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_name").value("John Doe"))
                .andExpect(jsonPath("$.followers[0].user_name").value("Michael Johnson"))
                .andExpect(jsonPath("$.followers[1].user_name").value("Jane Smith"))
                .andExpect(jsonPath("$.followers[2].user_name").value("Emily Brown"));
    }

    @Test
    @DisplayName("integración: orden inválido")
    public void testInvalidOrder() throws Exception {
        // Arrange
        int userId = 1;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                        .param("order", "invalid_order"))
                .andExpect(status().isBadRequest());
    }
}
