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

    @Test
    @DisplayName("verificar respuesta correcta el follow is ok")
    public void verifyCorrectFollow() throws Exception {
        followUrlTestIsOk(235, 101);
    }

    @Test
    @DisplayName("verificar si el vendedor no existe")
    public void checkIfTheSellerNoesNotExist() throws Exception {
        followUrlTestIsNotOk(1, 101, "comprador no encontrado");
    }

    @Test
    @DisplayName("verificar si el comprador no existe")
    public void verificarSiElCompradorNoExiste() throws Exception {
        followUrlTestIsNotOk(235, 90, "vendedor no encontrado");
    }


    private void followUrlTestIsOk(int userId, int userIdToFollow) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                        userId, userIdToFollow)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("follow exitoso"));
    }

    private void followUrlTestIsNotOk(int userId, int userIdToFollow, String errorText) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                        userId, userIdToFollow)).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(errorText));
    }
}
