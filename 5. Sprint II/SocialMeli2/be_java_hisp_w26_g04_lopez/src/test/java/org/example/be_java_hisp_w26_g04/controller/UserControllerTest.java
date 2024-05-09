package org.example.be_java_hisp_w26_g04.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String url = "/users";


    @Test
    @DisplayName("testea enpoint /users/{userId}/follow/{userIdToFollow} ok")
    void followOk() throws Exception {
        int userId = 789;
        int followTo = 123;
        this.mockMvc.perform(
                        post(url + "/{userId}/follow/{userIdToFollow}", userId, followTo))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("testea enpoint /users/{userId}/follow/{userIdToFollow} ya siguiendo")
    void followAlreadyFollowed() throws Exception {
        int userId = 456;
        int followTo = 234;
        this.mockMvc.perform(
                        post(url + "/{userId}/follow/{userIdToFollow}", userId, followTo))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void sortFollowers() {
    }

    @Test
    @DisplayName("testea enpoint /{userId}/followers/count ok")
    void getFollowersCount() throws Exception {
        int userId = 123;
        String userName = "JohnDoe";
        int followersCount = 1;
        this.mockMvc.perform(get(url + "/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").value(userName))
                .andExpect(jsonPath("$.followers_count").value(followersCount));
    }

    @Test
    @DisplayName("testea enpoint /{userId}/followers/count user no existe")
    void getFollowersCountNotExisiting() throws Exception {
        int userId = 9999;
        this.mockMvc.perform(get(url + "/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("test endpoint /{userId}/followed/list name_asc order")
    void sortFollowedAsc() throws Exception {
        int userId = 456;
        String userName = "JaneDoe";
        int followedId1 = 123;
        String followedName1 = "JohnDoe";
        int followedId2 = 234;
        String followedName2 = "JaneSmith";

        this.mockMvc.perform(get(url + "/{userId}/followed/list", userId)
                .param("order", "name_asc"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").value(userName))
                .andExpect(jsonPath("$.followed[0].user_id").value(followedId2))
                .andExpect(jsonPath("$.followed[0].user_name").value(followedName2))
                .andExpect(jsonPath("$.followed[1].user_id").value(followedId1))
                .andExpect(jsonPath("$.followed[1].user_name").value(followedName1));
    }

    @Test
    @DisplayName("test endpoint /{userId}/followed/list name_desc order")
    void sortFollowedDesc() throws Exception {
        int userId = 456;
        String userName = "JaneDoe";
        int followedId1 = 123;
        String followedName1 = "JohnDoe";
        int followedId2 = 234;
        String followedName2 = "JaneSmith";

        this.mockMvc.perform(get(url + "/{userId}/followed/list", userId)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").value(userName))
                .andExpect(jsonPath("$.followed[0].user_id").value(followedId1))
                .andExpect(jsonPath("$.followed[0].user_name").value(followedName1))
                .andExpect(jsonPath("$.followed[1].user_id").value(followedId2))
                .andExpect(jsonPath("$.followed[1].user_name").value(followedName2));
    }

    @Test
    @DisplayName("test endpoint /{userId}/followed/list orden invalido")
    void sortFollowedInvalidOrder() throws Exception {
        int userId = 456;

        this.mockMvc.perform(get(url + "/{userId}/followed/list", userId)
                        .param("order", "invalido"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName(" test endpoint /{userId}/unfollow/{userIdToUnfollow} ok")
    void unfollowOk() throws Exception {
        int userId = 456;
        int userIdToUnfollow = 234;

        this.mockMvc.perform(post(url + "/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName(" test endpoint /{userId}/unfollow/{userIdToUnfollow} Req invalido")
    void unfollowInvalidReq() throws Exception {
        int userId = 0;
        int userIdToUnfollow = 0;

        this.mockMvc.perform(post(url + "/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Hay errores de validación"))
                .andExpect(jsonPath("$.errors['unfollow.userId']").value("El ID debe ser mayor a cero."))
                .andExpect(jsonPath("$.errors['unfollow.userIdToUnfollow']").value("El ID debe ser mayor a cero."));
    }
}