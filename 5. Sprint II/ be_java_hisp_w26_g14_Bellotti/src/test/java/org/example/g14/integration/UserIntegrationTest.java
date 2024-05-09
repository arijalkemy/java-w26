package org.example.g14.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.g14.dto.response.ErrorResponseDto;
import org.example.g14.dto.response.UserFollowedResponseDto;
import org.example.g14.dto.response.UserFollowersResponseDto;
import org.example.g14.dto.response.UserResponseDto;
import org.example.g14.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class UserIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .findAndRegisterModules()
                .writer();
    }

    @Test
    @DisplayName("Encontrar todos los que me siguen OK")
    public void getFollowersListOk() throws Exception {
        //arrange
        int userId=2;

        UserFollowersResponseDto userFollowersExpected = new UserFollowersResponseDto(
                userId,
                "Jane Smith",
                List.of(
                        new UserResponseDto(1, "John Doe"),
                        new UserResponseDto(3, "Michael Johnson")
                ));

        //act
        ResultActions results = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        String obtained = results.andReturn().getResponse().getContentAsString();
        String expected = writer.writeValueAsString(userFollowersExpected);

        //assert
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Encontrar todos los que sigo OK")
    public void getFollowedListOk() throws Exception {
        //arrange
        int userId=2;

        UserFollowedResponseDto userFollowedExpected = new UserFollowedResponseDto(
                userId,
                "Jane Smith",
                List.of(
                        new UserResponseDto(4, "Emily Brown"),
                        new UserResponseDto(5, "William Taylor")
                ));

        //act
        ResultActions results = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        String obtained = results.andReturn().getResponse().getContentAsString();
        String expected = writer.writeValueAsString(userFollowedExpected);

        //assert
        Assertions.assertEquals(expected, obtained);
    }

    @Test
    @DisplayName("Seguir usuario OK")
    public void followOk() throws Exception {
        //arrange
        int userFollowerId = 1;
        int userToFollowId = 10;
        UserFollowedResponseDto userFollowedExpected = new UserFollowedResponseDto(1,
                "John Doe",
                List.of(
                        new UserResponseDto(5,"William Taylor"),
                        new UserResponseDto(6,"Olivia Martinez"),
                        new UserResponseDto(7,"James Anderson"),
                        new UserResponseDto(10,"Isabella Taylor")
                ));

        //act
        ResultActions results = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                        userFollowerId, userToFollowId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        String responseObtained = results.andReturn().getResponse().getContentAsString();
        String responseExpected = writer.writeValueAsString(userFollowedExpected);

        //assert
        Assertions.assertEquals(responseExpected, responseObtained);
    }

    @Test
    @DisplayName("Seguir usuario CONFLICT")
    public void followConflict() throws Exception {
        //arrange
        int userFollowerId = 1;
        int userToFollowId = 10;

        ErrorResponseDto messageExpected = new ErrorResponseDto("El usuario con id 1 ya sigue al usuario con id 10");

        //act
        ResultActions results = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",
                                userFollowerId, userToFollowId))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(messageExpected.getMessage()));;
    }


    @Test
    @DisplayName("Dejar de seguir usuario OK")
    public void unfollowOk() throws Exception {
        //arrange
        int userFollowerId = 1;
        int userToFollowId = 10;
        UserFollowedResponseDto userFollowedExpected = new UserFollowedResponseDto(1,
                "John Doe",
                List.of(
                        new UserResponseDto(5,"William Taylor"),
                        new UserResponseDto(6,"Olivia Martinez"),
                        new UserResponseDto(7,"James Anderson")
                ));

        //act
        ResultActions results = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}",
                                userFollowerId, userToFollowId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        String responseObtained = results.andReturn().getResponse().getContentAsString();
        String responseExpected = writer.writeValueAsString(userFollowedExpected);

        //assert
        Assertions.assertEquals(responseExpected, responseObtained);
    }
}
