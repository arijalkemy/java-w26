package com.sprint.socialmeli.integration;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.net.URI;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private Integer customerId;
    private Integer sellerId;
    private Integer nonexistentId;
    private Integer invalidId;
    private String invalidTypeId;


    @BeforeEach
    public void setup() throws Exception {
        this.customerId = 101;
        this.sellerId = 1;
        this.nonexistentId = 1000;
        this.invalidId = -1;
        this.invalidTypeId = "asd";
    }

    @AfterEach
    public void reset() throws Exception {
        this.unfollow();
    }

    private void unfollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + sellerId)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    // ----- Follow ----- START
    @Test
    public void correctFollowEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OK"));
    }

    @Test
    public void alreadyFollowEndpoint() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isConflict());
    }

    @Test
    public void followEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void followEndpointWithInvalidUserIdToFollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + invalidId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void followEndpointWithNonexistentUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + nonexistentId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void followEndpointWithNonexistentUserIdToFollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + nonexistentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void followEndpointWithInvalidTypeUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidTypeId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void followEndpointWithInvalidTypeIdToFollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + invalidTypeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void followEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//follow/" + sellerId)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void followEndpointWithoutParameterUserIdToFollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users/" + customerId + "/follow/")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // ----- Follow ----- END

    // ----- Count Followers ----- START
    @Test
    public void correctCountFollowersEndpoint() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", sellerId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(sellerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.follower_count").value(1));
    }

    @Test
    public void countFollowersEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", invalidId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void countFollowersEndpointWithNonexistentUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/count", nonexistentId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void countFollowersEndpointWithInvalidTypeUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/count", invalidTypeId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void countFollowersEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//followers/count")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // ----- Count Followers ----- END


    // ----- list Followers ----- START
    @Test
    public void correctListFollowersEndpoint() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", sellerId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(sellerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers.[0].user_id").value(customerId))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.followers.[0].user_name").value("Alice Johnson"));
    }

    @Test
    public void listFollowersEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", invalidId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void listFollowersEndpointWithNonexistentUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list", nonexistentId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void listFollowersEndpointWithInvalidType() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list", invalidTypeId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void listFollowersEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//followers/list")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // ----- list Followers ----- END

    // ----- list Followed Users ----- START
    @Test
    public void correctListFollowedUsersEndpoint() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", customerId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(customerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Alice Johnson"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed.[0].user_id").value(sellerId))
                .andExpect(MockMvcResultMatchers.jsonPath(
                        "$.followed.[0].user_name").value("John Doe"));
    }

    @Test
    public void listFollowedUsersEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", invalidId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void listFollowedUsersEndpointWithNonexistentUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list", nonexistentId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void listFollowedUsersEndpointWithInvalidType() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list", invalidTypeId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void listFollowedUsersEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//followed/list")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    // ----- list Followed Users ----- END


    // ----- unfollow ----- END
    @Test
    public void correctUnfollowEndpoint() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OK"));
    }

    @Test
    public void unfollowEndpointWithInvalidUserId() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void unfollowEndpointWithInvalidUserIdToUnfollow() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + invalidId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void unfollowEndpointWithNonexistentUserId() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + nonexistentId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void unfollowEndpointWithNonexistentUserIdToUnfollow() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + nonexistentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void unfollowEndpointInvalidTypeUserId() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidTypeId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void unfollowEndpointWithInvalidTypeUserIdToUnfollow() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + invalidTypeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void unfollowEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//unfollow/" + sellerId)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void unfollowEndpointWithoutParameterUserIdToUnfollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users/" + customerId + "/unfollow/")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // ----- unfollow ----- END


}
