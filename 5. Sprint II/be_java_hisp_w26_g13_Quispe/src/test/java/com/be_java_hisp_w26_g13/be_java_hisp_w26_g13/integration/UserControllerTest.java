package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest

@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testUserSuccessfullyFollowsAnotherUser() throws Exception {
        int userId = 1;
        int userIdToFollow = 3;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.message").isNotEmpty());
    }

    @Test
    public void testUserFollowsNonVendorUser() throws Exception {
        int userId = 1;
        int userIdToFollow = 7;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Cannot follow user that is not a vendor."));
    }

    @Test
    public void testUserFollowsHimself() throws Exception {
        int userId = 1;
        int sameUserId = 1;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, sameUserId))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User cannot follow itself."));
    }
}
