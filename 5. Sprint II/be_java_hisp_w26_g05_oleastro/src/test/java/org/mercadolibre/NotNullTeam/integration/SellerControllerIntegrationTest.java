package org.mercadolibre.NotNullTeam.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SellerControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Se quiere listar los seguidores del usuario vendedor con ID = 9999 " +
            "y lanza una excepcion porque no existe ningun usuario con dicho ID.")
    public void getListFollowersThrowsNotFoundExeption() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 9999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(
                        jsonPath("$.message")
                        .value("No se encontro el vendedor con ID = 9999 not found")
                );
    }
}
