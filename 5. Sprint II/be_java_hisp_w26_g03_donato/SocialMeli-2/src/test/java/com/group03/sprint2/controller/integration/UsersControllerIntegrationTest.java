package com.group03.sprint2.controller.integration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UsersControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    // Test de integracion para el endpoint getFollowersCount()
    @Test
    public void testGetFollowersCount() throws Exception {
        int sellerId = 1;

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").exists());
    }

    // Test de integracion para el endpoint getFollowersList()
    @Test
    public void testGetFollowersList() throws Exception {
        int sellerId = 1;

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").exists());
    }

    //Test de integracion para el endpoint followUser()
    @Test
    public void testFollowUser() throws Exception {
        int buyerId = 67890;
        int sellerId = 1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", buyerId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Successfully followed user: " + sellerId));
    }

}
