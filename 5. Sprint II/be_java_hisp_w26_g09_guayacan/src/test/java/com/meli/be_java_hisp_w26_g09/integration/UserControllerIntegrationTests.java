package com.meli.be_java_hisp_w26_g09.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;


    @Test
    void getFollowersListWithInvalidSellerTest() throws Exception {
        // Arrange
        int userId = 1;
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + userId + "/followers/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("The customers don't have an option for followers"));
    }

    @Test
    void getFollowersListWithValidSellerTest() throws Exception {
        // Arrange
        int userId = 2;
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + userId + "/followers/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(2))
                .andExpect(jsonPath("$.followers").isArray())
                .andExpect(jsonPath("$.followers[0].user_id").value(1));
    }

    @Test
    void getFollowedListWithInvalidCustomerTest() throws Exception {
        // Arrange
        int userId = 2;
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + userId + "/followed/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("The seller does not have the option to follow"));
    }

    @Test
    void getFollowedListWithValidCustomerTest() throws Exception {
        // Arrange
        int userId = 1;
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + userId + "/followed/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.followed").isArray())
                .andExpect(jsonPath("$.followed[0].user_id").value(2));
    }

    @Test
    void getFollwersCountTest() throws Exception {
        // Arrange
        int userId = 2;
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + userId + "/followers/count"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(2))
                .andExpect(jsonPath("$.followers_count").value(3));
    }

    @Test
    void getFollowersCountWithInvalidSellerTest() throws Exception {
        // Arrange
        int userId = 1;
        // Act
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + userId + "/followers/count"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message")
                        .value("The customers don't have an option for followers"));
    }



}
