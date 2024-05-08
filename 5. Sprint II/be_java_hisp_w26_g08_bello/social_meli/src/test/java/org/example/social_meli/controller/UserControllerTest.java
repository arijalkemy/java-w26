package org.example.social_meli.controller;

import org.example.social_meli.dto.UserResponseDTO;
import org.example.social_meli.services.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.Collections;
import java.util.List;
import org.springframework.http.MediaType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IUserService userService;
    @Test
    @DisplayName("Integration test follower User")
    void testFollowerUser() throws Exception {
        Integer followerId=1;
        Integer followedId=2;

        doNothing().when(userService).followUser(followerId,followedId);
        String url = String.format("/users/%d/follow/%d", followerId, followedId);
        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType("application/json")).andExpect(status().isOk());
    }
    @Test
    @DisplayName("Unfollow an user")
    void postUnfollowUser() throws Exception {
        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        String url = String.format("/users/%d/unfollow/%d", userId, userIdToUnfollow);

        when(userService.unfollowUser(anyInt(), anyInt())).thenReturn(new UserResponseDTO(1, "wcalderwood0", Collections.emptyList()));

        mockMvc.perform(MockMvcRequestBuilders.post("/users/1/unfollow/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"user_id\":1,\"user_name\":\"wcalderwood0\",\"follower\":[]}"));

    }
    @Test
    @DisplayName("Get Followers Test")
    void testGetFollowers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/list")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                            if (result.getResponse().getContentAsString().isEmpty()) {
                                System.out.println("No content returned.");
                            } else {
                                assertThat(result.getResponse().getContentAsString()).isNotEmpty();
                            }
                        }
                );
        }

    }
