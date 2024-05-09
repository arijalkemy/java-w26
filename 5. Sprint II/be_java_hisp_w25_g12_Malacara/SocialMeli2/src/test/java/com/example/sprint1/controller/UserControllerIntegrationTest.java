package com.example.sprint1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test for the getFollowersCount US0002 happy path
     * It should return a json with the user_id, user_name and followers_count
     * @throws Exception
     */
    @Test
    public void getFollowersCountTest() throws Exception {
        Integer userId = 3;// an existing user id

        // Mock perform a get request to the endpoint and check the response status and content
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json("{\"user_id\": 3, \"user_name\": \"user3\", \"followers_count\": 2}"));
    }

    /**
     * Test for the getFollowersCount US0002 exception path
     * It should return a json with the user_id, user_name and followers_count
     * @throws Exception
     */
    @Test
    public void getFollowersCountExceptionTest() throws Exception {
        Integer userId = 7;// a non existing user id

        // Mock perform a get request to the endpoint and check the response status and content
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId)
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.status().is4xxClientError())
            .andExpect(MockMvcResultMatchers.content().json("{\"message\": \"No se encontró al vendedor\"}"));
        };
}
