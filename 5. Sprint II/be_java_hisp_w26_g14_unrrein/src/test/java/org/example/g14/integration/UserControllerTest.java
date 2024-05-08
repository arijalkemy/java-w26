package org.example.g14.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Integracion: camino feliz de endpoint /{userId}/follow/{userIdToFollow}")
    public void followTestOk() throws Exception {

        int userId = 1;
        int userIdToFollow = 15;

        mockMvc
            .perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                jsonPath("$.user_id").value(userId)
            )
            .andExpect(
                jsonPath("$.followed.*.user_id").value(hasItem(userIdToFollow))
            );
    }
}
