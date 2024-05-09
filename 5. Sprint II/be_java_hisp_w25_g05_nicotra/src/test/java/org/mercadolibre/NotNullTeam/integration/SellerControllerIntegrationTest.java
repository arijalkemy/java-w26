package org.mercadolibre.NotNullTeam.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class SellerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Verifica que el endpoint getFollowersCount responda correctamente")
    public void testGetFollowersCountOk() throws Exception {
        ResultActions result = mockMvc.perform(get("/users/{userId}/followers/count", 5L));

        result.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count")
                        .value(0));
    }

    @Test
    @DisplayName("Verifica que el endpoint getFollowersCount devuelva un bad request dado un ID incorrecto")
    public void testGetFollowersCountBadRequest() throws Exception {
        ResultActions result =  mockMvc.perform(get("/users/{userId}/followers/count", -5L));

        result.andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Verifica que el endpoint getListFollowers responda correctamente")
    public void testGetListFollowersOk() throws Exception {
        ResultActions result = mockMvc.perform(get("/users/{userId}/followers/list", 5L));

        result.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").isArray());
    }

    @Test
    @DisplayName("Verifica que el endpoint getListFollowers responda correctamente si le envio un RequestParam")
    public void testGetListFollowersWithRequestParamOk() throws Exception {
        ResultActions result = mockMvc.perform(get("/users/{userId}/followers/list", 5L)
                .param("order", "name_asc"));

        result.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers")
                        .isArray());
    }
}
