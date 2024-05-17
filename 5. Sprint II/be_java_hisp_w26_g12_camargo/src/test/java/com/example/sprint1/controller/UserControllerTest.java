package com.example.sprint1.controller;

import com.example.sprint1.model.User;
import com.example.sprint1.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepositoryImpl userRepository;

    @BeforeEach
    public void setup() throws Exception {
        // Initialize the repository with some users for testing
        userRepository.loadDatabase();
    }

    @Test
    public void testUserCanFollowAnotherUser() throws Exception {
        Integer followerId = 1;
        Integer followedId = 2;

        // Perform the follow operation using MockMvc to simulate the POST request
        mockMvc.perform(post("/users/{userID}/follow/{userIdToFollow}", followerId, followedId))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("User followed successfully")));

        // Verify that the follow relationship has been updated
        User follower = userRepository.findUserById(followerId);
        User followed = userRepository.findUserById(followedId);
        assertTrue(follower.getFollowed().contains(followedId));
        assertTrue(followed.getFollowers().contains(followerId));
    }
}
