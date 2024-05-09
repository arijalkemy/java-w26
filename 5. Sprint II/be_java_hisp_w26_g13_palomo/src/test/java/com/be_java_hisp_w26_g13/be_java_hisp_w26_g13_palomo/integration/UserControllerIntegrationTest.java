package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Unfollow integration ok")
    public void unfollowUserTestOk() throws Exception {
        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2)
                .contentType(MediaType.APPLICATION_JSON)
                );

        System.console().printf(results.andReturn().getResponse().getContentAsString());

        results
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(2));

    }

    @Test
    @DisplayName("Unfollow integration not found user")
    public void unfollowUserTestNotFoundUser() throws Exception {
        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 234, 2)
                .contentType(MediaType.APPLICATION_JSON)
        );

        System.console().printf(results.andReturn().getResponse().getContentAsString());

        results
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User with id 234 does not exist."));

    }

    @Test
    @DisplayName("Followers Count integration ok")
    public void followersCountTest() throws Exception {
        ResultActions results = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1)
                .contentType(MediaType.APPLICATION_JSON)
        );

        System.console().printf(results.andReturn().getResponse().getContentAsString());

        results
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }
}
