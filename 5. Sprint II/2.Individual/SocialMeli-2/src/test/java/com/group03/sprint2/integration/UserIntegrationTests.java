package com.group03.sprint2.integration;

import com.group03.sprint2.controller.UsersController;
import com.group03.sprint2.dto.SellerNumberOfFollowersDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import com.group03.sprint2.dto.response.SellerResponseDTO;
import com.group03.sprint2.dto.response.UserDataResponseDTO;
import com.group03.sprint2.entity.Seller;
import com.group03.sprint2.entity.UserData;
import com.group03.sprint2.service.implementation.UsersServiceImpl;
import com.group03.sprint2.utils.Constants;
import jakarta.validation.constraints.Size;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.management.DescriptorKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Follow user integration test")
    void followUserTest() throws Exception {
        // Prepare mock data
        Integer userId = 12345;
        Integer userIdToFollow = 2;

        // Perform the request using MockMvc
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Successfully followed user: " + userIdToFollow));
    }

    @Test
    public void followUser_WhenSellerNotFound_ShouldThrowBadRequestException() throws Exception {
        // Prepare mock data
        Integer userId = 43;
        Integer userIdToFollow = 2;

        // Perform the request and expect a BadRequestException
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("There is not buyer with ID: " + userId));
    }

    @Test
    @DisplayName("Count seller followers integration test")
    void getFollowersCountTest() throws Exception {
        // Prepare mock data
        Integer sellerId = 1;
        Integer numberOfFollowers = 2;

        // Perform the request using MockMvc
        mockMvc.perform(get("/users/{userId}/followers/count", sellerId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.followers").value(numberOfFollowers));
    }

    @Test
    @DisplayName("Get seller followers list integration test")
    void getFollowersListTest() throws Exception {
        // Prepare mock data
        Integer userId = 1;

        // Perform the request using MockMvc
        mockMvc.perform(get("/users/{userId}/followers/list", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").value("nombre_vendedor_1"))
                .andExpect(jsonPath("$.followers[0].user_id").value(12345))
                .andExpect(jsonPath("$.followers[0].user_name").value("nombre_de_usuario_1"))
                .andExpect(jsonPath("$.followers[1].user_id").value(67890))
                .andExpect(jsonPath("$.followers[1].user_name").value("nombre_de_usuario_2"));
    }

    @Test
    @DisplayName("Get buyer followers list integration test")
    void getFollowedListTest() throws Exception {
        // Prepare mock data
        Integer userId = 12345;

        // Perform the request using MockMvc
        mockMvc.perform(get("/users/{userId}/followed/list", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").value("nombre_de_usuario_1"))
                .andExpect(jsonPath("$.followed[0].user_id").value(1))
                .andExpect(jsonPath("$.followed[0].user_name").value("nombre_vendedor_1"))
                .andExpect(jsonPath("$.followed[1].user_id").value(3))
                .andExpect(jsonPath("$.followed[1].user_name").value("nombre_vendedor_1"));
    }


    @Test
    @DisplayName("Unfollow user integration test")
    @Disabled
    void testUnfollowUser() throws Exception {
        // Prepare mock data
        Integer userId = 12345;
        Integer userIdToUnfollow = 2;
        String message = "Successfully unfollowed user with ID: " + userIdToUnfollow;

        // Perform the request using MockMvc
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(message));
    }
}
