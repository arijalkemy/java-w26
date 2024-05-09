package org.example.SocialMeli2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Clase de prueba para la integración del controlador FollowController.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class FollowControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Prueba el método getSellerFollowers del controlador FollowController.
     * Este método debería devolver una respuesta HTTP con estado 200 (OK) si la solicitud es exitosa.
     *
     * @throws Exception si ocurre un error durante la ejecución de la prueba.
     */
    @Test
    public void testGetSellerFollowers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/101/followers/list")
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Prueba el método getFollowedSellers del controlador FollowController.
     * Este método debería devolver una respuesta HTTP con estado 200 (OK) si la solicitud es exitosa.
     *
     * @throws Exception si ocurre un error durante la ejecución de la prueba.
     */
    @Test
    public void testGetFollowedSellers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/234/followed/list")
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}