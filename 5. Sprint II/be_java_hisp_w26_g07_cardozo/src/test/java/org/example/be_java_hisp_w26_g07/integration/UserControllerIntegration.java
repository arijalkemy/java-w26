package org.example.be_java_hisp_w26_g07.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Verifica que un usuario pueda seguir a un vendedor")
    public void followSellerHappyPath() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}","9","4"))
                .andExpect(status().isNoContent())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("true"));
    }

    @Test
    @DisplayName("Verifica que un usuario no pueda seguir a un usuario que no es vendedor")
    public void followSellerSadPath() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}","9","8"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Existe el usuario pero no es vendedor"));
    }

    @Test
    @DisplayName("Verifica que un usuario pueda dejar de seguir a un vendedor")
    public void unfollowSellerHappyPath() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}","5","2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Se ha dejado de seguir al usuario"));
    }

    //TEST DE EXCEPCIONES GENERALES DEL CONTROLADOR EN LA APLICACIÓN

    @Test
    @DisplayName("Verifica la excepción 400 de ConstraintViolationException por id negativo")
    public void verifyConstraintViolationExceptionAttributes() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}","-3","4"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(
                        "Por favor corregir los siguientes datos: "));
    }

    @Test
    @DisplayName("Verifica la excepción 400 de NumberFormatException por id no numérico")
    public void verifyNumberFormatExceptionAttributes() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}","ABC","4"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El valor ingresado en la ruta debe ser "
                        + "numérico"));
    }

}
