package org.example.SocialMeli2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
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

    /**
     * Prueba para verificar que el seguimiento es correcto.
     * <p>
     * Este método de prueba verifica que el seguimiento entre usuarios es exitoso.
     * Se realiza una petición POST a la ruta "/users/{userId}/follow/{userIdToFollow}".
     * Se espera que la respuesta tenga un estado HTTP 200 (OK) y que el contenido de la respuesta sea "follow exitoso".
     */
    @Test
    @DisplayName("verificar respuesta correcta el follow is ok")
    public void verifyCorrectFollow() throws Exception {
        followUrlTestIsOk(235, 101);
    }

    /**
     * Prueba para verificar si el vendedor no existe.
     * <p>
     * Este método de prueba verifica que se recibe un error cuando se intenta seguir a un vendedor que no existe.
     * Se realiza una petición POST a la ruta "/users/{userId}/follow/{userIdToFollow}".
     * Se espera que la respuesta tenga un estado HTTP 400 (Bad Request) y que el mensaje de error sea "comprador no encontrado".
     *
     */
    @Test
    @DisplayName("verificar si el vendedor no existe")
    public void checkIfTheSellerNoesNotExist() throws Exception {
        followUrlTestIsNotOk(1, 101, "comprador no encontrado");
    }

    /**
     * Prueba para verificar si el comprador no existe.
     * <p>
     * Este método de prueba verifica que se recibe un error cuando un comprador que no existe intenta seguir a un vendedor.
     * Se realiza una petición POST a la ruta "/users/{userId}/follow/{userIdToFollow}".
     * Se espera que la respuesta tenga un estado HTTP 400 (Bad Request) y que el mensaje de error sea "vendedor no encontrado".
     */
    @Test
    @DisplayName("verificar si el comprador no existe")
    public void verificarSiElCompradorNoExiste() throws Exception {
        followUrlTestIsNotOk(235, 90, "vendedor no encontrado");
    }


    /**
     * Método auxiliar para realizar una petición de seguimiento exitosa.
     * <p>
     * Este método realiza una petición POST a la ruta "/users/{userId}/follow/{userIdToFollow}" y verifica que la respuesta sea exitosa.
     *
     * @param userId el ID del usuario que realiza el seguimiento.
     * @param userIdToFollow el ID del usuario a seguir.
     * @throws Exception si ocurre algún error durante la petición.
     */
    private void followUrlTestIsOk(int userId, int userIdToFollow) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                        userId, userIdToFollow)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("follow exitoso"));
    }

    /**
     * Método auxiliar para realizar una petición de seguimiento que resulta en un error.
     * <p>
     * Este método realiza una petición POST a la ruta "/users/{userId}/follow/{userIdToFollow}" y verifica que la respuesta tenga un estado HTTP 400 (Bad Request).
     *
     * @param userId el ID del usuario que realiza el seguimiento.
     * @param userIdToFollow el ID del usuario a seguir.
     * @param errorText el mensaje de error esperado.
     * @throws Exception si ocurre algún error durante la petición.
     */
    private void followUrlTestIsNotOk(int userId, int userIdToFollow, String errorText) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                        userId, userIdToFollow)).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(errorText));
    }
}
