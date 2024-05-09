package org.mercadolibre.NotNullTeam.integracion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mercadolibre.NotNullTeam.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegracionSellerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test para obtener la cantidad de seguidores de un vendedor")
    public void getFollowersCount() throws Exception {
        // Datos de prueba
        Long userId= 3L;

        this.mockMvc.perform(
                get("/users/{userId}/followers/count", userId))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(2));
    }

    @Test
    @DisplayName("Test para obtener la lista de seguidores de un vendedor")
    public void getListFollowers() throws Exception {
        // Datos de prueba
        Long userId= 3L;
        String order = "name_asc";

        this.mockMvc.perform(
                get("/users/{userId}/followers/list", userId)
                        .param("order", order))
                .andExpect(status().isOk());
    }



}