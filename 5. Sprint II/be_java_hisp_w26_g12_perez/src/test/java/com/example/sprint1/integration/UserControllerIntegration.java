package com.example.sprint1.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserControllerIntegration {
    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;
    private Integer userId;
    private Integer userToFollowId;

    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                 .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                 .writer();
        userId = 1;
        userToFollowId = 2;
    }

    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testFollowUser() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}", userId, userToFollowId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void testFollowUserWithUnexistingUser() throws Exception {
        userToFollowId = 999;
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "User to follow not found");
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/follow/{userIdToFollow}", userId, userToFollowId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testGetFollowersCount() throws Exception {
        Map<String, Integer> expectedResponse = new HashMap<>();
        expectedResponse.put("user_id", userId);
        expectedResponse.put("followers_count", 0);
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testGetFollowerList() throws Exception {
        userId = 4;
        Map<String, Object> expectedResponse = new HashMap<>();
        expectedResponse.put("user_id", userId);
        expectedResponse.put("user_name", "user4");

        List<Map<String, Object>> followed = new ArrayList<>();

        Map<String, Object> user2 = new HashMap<>();
        user2.put("user_id", 3);
        user2.put("user_name", "user3");
        followed.add(user2);

        expectedResponse.put("followed", followed);
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testGetFollowedUsersList() throws Exception {
        Map<String, Object> expectedResponse = new HashMap<>();
        expectedResponse.put("user_id", userId);
        expectedResponse.put("user_name", "user1");

        List<Map<String, Object>> followed = new ArrayList<>();
        Map<String, Object> user1 = new HashMap<>();

        expectedResponse.put("followed", followed);
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testSetUnfollowUser() throws Exception {
        userId = 4;
        userToFollowId = 3;
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}", userId, userToFollowId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testSetUnfollowUserWithUnexistingUser() throws Exception {
        userId = 4;
        userToFollowId = 999;
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "User to unfollow not found: "+ userToFollowId);
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}", userId, userToFollowId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testSetUnfollowUserNotFollowed() throws Exception {
        userId = 4;
        userToFollowId = 5;
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "You are not following this user: "+ userToFollowId);
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userID}/unfollow/{userIdToUnfollow}", userId, userToFollowId)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedResponseJSON));
    }

}
