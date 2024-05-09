package com.meli.be_java_hisp_w26_g10.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = {com.api.socialmeli.BeJavaHispW26G10Application.class})
@AutoConfigureMockMvc
public class SocialMeliControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test de Integracion - Follow")
    public void followUserIntegrationTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,6))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Test de Integracion - Follow con un comprador que no existe")
    public void followUserIntegrationTestFailedBuyer() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",100,6))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Test de Integracion - Follow con un vendedor que no existe")
    public void followUserIntegrationTestFailedSeller() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,600))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Test de Integracion - Obtener Todos los Compradores")
    public void getAllBuyersIntegrationTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Test de Integracion - Contador de Seguidores")
    public void getFollowerCountIntegrationTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Test de Integracion - Contador de Seguidores en un usuario que no existe")
    public void getFollowerCountIntegrationTestFailed() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/100/followers/count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
