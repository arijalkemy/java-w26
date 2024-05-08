package com.sprint.socialmeli.integration;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    public void setup() throws Exception {
        this.unfollow();
    }

    private void unfollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + 101 + "/unfollow/" + 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    // ----- Follow ----- START
    @Test
    public void correctFollowEndpoint() throws Exception {
        int userId = 101;
        int userIdToFollow = 1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/follow/" + userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OK"));
    }

    @Test
    public void followEndpointWithInvalidUserId() throws Exception {
        int invalidUserId = -1;
        int userIdToFollow = 1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidUserId + "/follow/" + userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void followEndpointWithInvalidUserIdToFollow() throws Exception {
        int userId = 101;
        int invalidUserIdToFollow = -1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/follow/" + invalidUserIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void followEndpointWithNonExistUserId() throws Exception {
        int invalidUserId = 1000;
        int userIdToFollow = 1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidUserId + "/follow/" + userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void followEndpointWithNonExistUserIdToFollow() throws Exception {
        int invalidUserId = 101;
        int userIdToFollow = 1000;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidUserId + "/follow/" + userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void followEndpointWithInvalidTypeUserId() throws Exception {
        String invalidUserId = "asd";
        int userIdToFollow = 1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidUserId + "/follow/" + userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void followEndpointWithInvalidTypeIdToFollow() throws Exception {
        int invalidUserId = 101;
        String userIdToFollow = "asd";

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidUserId + "/follow/" + userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    // ----- Follow ----- END

    // ----- Count Followers ----- START
    @Test
    public void correctCountFollowersEndpoint() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.follower_count").value(1));
    }

    @Test
    public void countFollowersEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", -1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void countFollowersEndpointWithNoneExistUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 100))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void countFollowersEndpointWithInvalidTypeUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", "asd"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    // ----- Count Followers ----- END


    // ----- list Followers ----- START
    @Test
    public void correctListFollowersEndpoint() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers.[0].user_id").value(101))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.followers.[0].user_name").value("Alice Johnson"));
    }

    @Test
    public void listFollowersEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", -1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void listFollowersEndpointWithNoneExistUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1000))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void listFollowersEndpointWithInvalidType() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", "asd"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    // ----- list Followers ----- END

    // ----- list Followed Users ----- START
    @Test
    public void correctListFollowedUsersEndpoint() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 101))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(101))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Alice Johnson"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed.[0].user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.followed.[0].user_name").value("John Doe"));
    }

    @Test
    public void listFollowedUsersEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", -101))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void listFollowedUsersEndpointWithNoneExistUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1001))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void listFollowedUsersEndpointWithInvalidType() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", "asd"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    // ----- list Followed Users ----- END


    // ----- unfollow ----- END
    @Test
    public void correctUnfollowEndpoint() throws Exception {
        this.correctFollowEndpoint();

        int userId = 101;
        int userIdToUnfollow = 1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/unfollow/" + userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OK"));
    }

    @Test
    public void unfollowEndpointWithInvalidUserId() throws Exception {
        this.correctFollowEndpoint();

        int userId = -101;
        int userIdToUnfollow = 1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/unfollow/" + userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void unfollowEndpointWithInvalidUserIdToUnfollow() throws Exception {
        this.correctFollowEndpoint();

        int userId = 101;
        int userIdToUnfollow = -1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/unfollow/" + userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void unfollowEndpointWithNoneExistUserId() throws Exception {
        this.correctFollowEndpoint();

        int userId = 1001;
        int userIdToUnfollow = 1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/unfollow/" + userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void unfollowEndpointWithNoneExistUserIdToUnfollow() throws Exception {
        this.correctFollowEndpoint();

        int userId = 101;
        int userIdToUnfollow = 1001;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/unfollow/" + userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void unfollowEndpointInvalidTypeExistUserId() throws Exception {
        this.correctFollowEndpoint();

        String userId = "asd";
        int userIdToUnfollow = 1;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/unfollow/" + userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void unfollowEndpointWithInvalidTypeUserIdToUnfollow() throws Exception {
        this.correctFollowEndpoint();

        int userId = 101;
        String userIdToUnfollow = "asd";

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + userId + "/unfollow/" + userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    // ----- unfollow ----- END


}
