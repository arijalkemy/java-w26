package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.integration;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.*;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    public void setup() {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();
    }

    @Test
    public void followUserTest() throws Exception {
        int followerId = 5;
        int userToFollowId = 1;
        ResponseFollowDTO expectedResponse = new ResponseFollowDTO(
                5,
                "You are now following user Alice Morrison"
        );

        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.post(
                        "/users/{userId}/follow/{userIdToFollow}",
                        followerId,
                        userToFollowId)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)));
    }

    @Test
    public void unfollowUserTest() throws Exception {
        int unfollowerId = 2;
        int userToUnfollowId = 1;
        ResponseFollowDTO expectedResponse = new ResponseFollowDTO(
                1,
                "You have unfollowed user Alice Morrison"
        );

        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.post(
                        "/users/{userId}/unfollow/{userIdToUnFollow}",
                        unfollowerId,
                        userToUnfollowId)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)));
    }

    @Test
    public void getFollowedSellersTest() throws Exception {
        int userId = 1;
        ResponseFollowedByUserDTO expectedResponse = new ResponseFollowedByUserDTO (
                1,
                "Alice Morrison",
                List.of(new UserDTO(2, "Bob Smith"))
        );

        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/users/{userId}/followed/list",
                        userId)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)));

    }

    @Test
    public void getFollowersListTest() throws Exception {
        int userId = 2;
        ResponseUserFollowersDTO expectedResponse = new ResponseUserFollowersDTO (
                2,
                "Bob Smith",
                List.of(
                        new UserDTO(1, "Alice Morrison"),
                        new UserDTO(15, "Oscar Lee")
                )
        );

        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/users/{userId}/followers/list",
                        userId)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)));

    }

    @Test
    public void getFollowersCountTest() throws Exception {
        int userId = 2;
        ResponseFollowersCountDTO expectedResponse = new ResponseFollowersCountDTO ();
        expectedResponse.setUserId(userId);
        expectedResponse.setUserName("Bob Smith");
        expectedResponse.setFollowersCount(2);


        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/users/{userId}/followers/count",
                        userId)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)));

    }
}
