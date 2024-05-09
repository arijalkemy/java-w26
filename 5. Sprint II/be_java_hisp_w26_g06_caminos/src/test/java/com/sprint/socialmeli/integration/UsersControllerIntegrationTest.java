package com.sprint.socialmeli.integration;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Customer follow Seller")
    public void correctFollowEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OK"));
    }

    @Test
    @DisplayName("Customer already follows Seller")
    public void alreadyFollowEndpoint() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isConflict());
    }

    @Test
    @DisplayName("Can't entered an invalid Customer ID '-1'")
    public void followEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Can't entered an invalid Seller ID '-1'")
    public void followEndpointWithInvalidUserIdToFollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + invalidId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Can't entered a nonexistent Customer ID '1000'")
    public void followEndpointWithNonexistentUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + nonexistentId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Can't entered a nonexistent Seller ID  '1000'")
    public void followEndpointWithNonexistentUserIdToFollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + nonexistentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Can't entered a string 'asd' as Customer ID")
    public void followEndpointWithInvalidTypeUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidTypeId + "/follow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Can't entered a string 'asd' as Seller ID")
    public void followEndpointWithInvalidTypeIdToFollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + invalidTypeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Do not allow the Customer ID parameter to be entered blank")
    public void followEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//follow/" + sellerId)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Do not allow the Seller ID parameter to be entered blank")
    public void followEndpointWithoutParameterUserIdToFollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users/" + customerId + "/follow/")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // ----- Follow ----- END

    // ----- Count Followers ----- START
    @Test
    @DisplayName("Get Seller's follower account")
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
    @DisplayName("Can't entered an invalid Seller ID '-1'")
    public void countFollowersEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", invalidId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Can't entered an nonexistent Seller ID '1000'")
    public void countFollowersEndpointWithNonexistentUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/count", nonexistentId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Can't entered a string 'asd' as Seller ID")
    public void countFollowersEndpointWithInvalidTypeUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/count", invalidTypeId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Do not allow the Seller ID parameter to be entered blank")
    public void countFollowersEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//followers/count")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // ----- Count Followers ----- END


    // ----- list Followers ----- START
    @Test
    @DisplayName("Get Seller's follower list")
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
    @DisplayName("Can't entered an invalid '-1' as Seller ID")
    public void listFollowersEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", invalidId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Can't entered an nonexistent '1000' as Seller ID")
    public void listFollowersEndpointWithNonexistentUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list", nonexistentId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Can't entered a string 'asd' as Seller ID")
    public void listFollowersEndpointWithInvalidType() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followers/list", invalidTypeId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Do not allow the Seller ID parameter to be entered blank")
    public void listFollowersEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//followers/list")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // ----- list Followers ----- END

    // ----- list Followed Users ----- START
    @Test
    @DisplayName("Get Customer's followed list")
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
    @DisplayName("Can't entered an invalid '-1' as Customer ID")
    public void listFollowedUsersEndpointWithInvalidUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", invalidId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Can't entered a nonexistent '1000' as Customer ID")
    public void listFollowedUsersEndpointWithNonexistentUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list", nonexistentId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Can't entered a String 'asd' as Customer ID")
    public void listFollowedUsersEndpointWithInvalidType() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                "/users/{userId}/followed/list", invalidTypeId))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Do not allow the Seller ID parameter to be entered blank")
    public void listFollowedUsersEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//followed/list")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    // ----- list Followed Users ----- END


    // ----- unfollow ----- END
    @Test
    @DisplayName("Customer unfollow a Seller")
    public void correctUnfollowEndpoint() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("OK"));
    }

    @Test
    @DisplayName("Can't entered an invalid '-1' as Customer ID")
    public void unfollowEndpointWithInvalidUserId() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Can't entered an invalid '-1' as Seller ID")
    public void unfollowEndpointWithInvalidUserIdToUnfollow() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + invalidId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Can't entered a nonexisten '1000' as Customer ID")
    public void unfollowEndpointWithNonexistentUserId() throws Exception {
        this.correctFollowEndpoint();
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + nonexistentId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Can't entered a nonexisten '1000' as Seller ID")
    public void unfollowEndpointWithNonexistentUserIdToUnfollow() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + nonexistentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Can't entered a String 'asd' as Customer ID")
    public void unfollowEndpointInvalidTypeUserId() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + invalidTypeId + "/unfollow/" + sellerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Can't entered a String 'asd' as Seller ID")
    public void unfollowEndpointWithInvalidTypeUserIdToUnfollow() throws Exception {
        this.correctFollowEndpoint();

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + invalidTypeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Do not allow the Customer ID parameter to be entered blank")
    public void unfollowEndpointWithoutParameterUserId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users//unfollow/" + sellerId)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DisplayName("Do not allow the Seller ID parameter to be entered blank")
    public void unfollowEndpointWithoutParameterUserIdToUnfollow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/users/" + customerId + "/unfollow/")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    // ----- unfollow ----- END


}
