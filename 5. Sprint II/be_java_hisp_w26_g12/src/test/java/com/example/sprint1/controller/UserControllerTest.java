package com.example.sprint1.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;


    /**
     * Integration test for the functionality of retrieving the count of followers for a user (Requirement US 0002).
     *
     * @throws Exception if an error occurs during the test execution
     * @implNote This test verifies the behavior when the user has no followers.
     *           Expects the followers count to be 0.
     */
    @Test
    public void getFollowersCountTest() throws Exception {
        // Assume that there is a user with ID 1 who has 3 followers
        Integer userId = 1;
        Integer expectedFollowerCount = 0; // Expected number of followers for the user

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}/followers/count", userId) //Values and URL Construction
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Check if the response status is 200 (OK)
                .andExpect(jsonPath("$.followers_count").value(expectedFollowerCount)) // Check if the followers count is as expected
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)); // Ensure the response content type is JSON
    }

    /**
     * Integration test for the functionality of retrieving the count of followers for a user who has followers (Requirement US 0002).
     *
     * @throws Exception if an error occurs during the test execution
     * @implNote This test verifies the behavior when the user has followers.
     *           Expects the followers count to be 2.
     */
    @Test
    public void getFollowersCountTestWithFollowers() throws Exception {
        // Assume that there is a user with ID 3 who has 2 followers
        Integer userId = 3;
        Integer expectedFollowerCount = 2; // Expected number of followers for the user

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}/followers/count", userId) //Values and URL Construction
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Check if the response status is 200 (OK)
                .andExpect(jsonPath("$.followers_count").value(expectedFollowerCount)) // Check if the followers count is as expected
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)); // Ensure the response content type is JSON
    }

    /**
     * Integration test for the functionality of retrieving the count of followers for a non-existent user (Requirement US 0002).
     *
     * @throws Exception if an error occurs during the test execution
     * @implNote This test verifies the behavior when the user does not exist.
     *           Expects a NotFoundException.
     */
    @Test
    public void getFollowersCountTestNoUser() throws Exception {
        // Assume that there is a user with ID 0 that does not exist
        Integer userId = 0;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}/followers/count", userId) //Values and URL Construction
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()) // Check if the response status is 404 (Not Found)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)); // Ensure the response content type is JSON
    }


}
