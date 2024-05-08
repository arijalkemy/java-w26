package com.meli.be_java_hisp_w26_g10.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Followed List By Id Integration Test Ok")
    void getFollowedListByIdTestOk() throws Exception{
        Integer idUser = 1;
        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list",idUser))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("Followed List By Id Integration Test User Not Found")
    void getFollowedListByIdTestUserNotFound() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list",20))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El usuario no existe o no se encuentra registrado."))
                .andReturn();

    }

    @Test
    @DisplayName("Follow Integration test")
    public void followSellerIntegrationOk() throws Exception {
        Integer userId = 1;
        Integer userToFollow = 4;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",userId,userToFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Unfollow Integration test")
    public void unFollowSellerIntegrationOk() throws Exception {
        Integer userId = 1;
        Integer userToUnFollow = 2;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnFollow}",userId,userToUnFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
