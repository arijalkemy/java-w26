package com.sprint.socialmeli.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    private Integer customerId = 101;
    private Integer sellerId = 1;

    @AfterEach
    public void tearDown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + (customerId + 1) + "/unfollow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + (sellerId + 1)));

    }

    @Test
    @DisplayName("1 - Follow correctly")
    public void followCorrectlyTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("2 - Customer cannot follow customer")
    public void customerCannotFollowCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + (customerId + 1)))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("3 - Customer cannot follow the seller multiple times")
    public void customerCannotFollowMultipleTimes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId))
                .andDo(print()).andExpect(status().isConflict());
    }

    @Test
    @DisplayName("4 - Unfollow correctly")
    public void unfollowCorrectlyTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + sellerId))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("5 - Unfollow non followed is not allowed")
    public void unFollowNonFollowedIsNotAllowed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/unfollow/" + (sellerId + 1)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("6 - Count followers of seller correctly")
    public void countFollowersOfSellerCorrectly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + sellerId + "/followers/count"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.follower_count").value(1));
    }

    @Test
    @DisplayName("7 - Customers do not have followers it is not allowed")
    public void countFollowersOfCustomerIsNotAllowed() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + customerId + "/followers/count"))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("8 - Get followers of seller correctly unordered")
    public void getFollowersOfSellerCorrectlyUnordered() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + (customerId + 1) + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + sellerId + "/followers/list"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id")
                        .value(customerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[1].user_id")
                        .value(customerId + 1));
    }

    @Test
    @DisplayName("9 - Get followers of seller correctly ordered asc")
    public void getFollowersOfSellerCorrectlyOrderedAsc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + (customerId + 1) + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + sellerId + "/followers/list?order=name_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id")
                        .value(customerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[1].user_id")
                        .value(customerId + 1));
    }

    @Test
    @DisplayName("10 - Get followers of seller correctly ordered desc")
    public void getFollowersOfSellerCorrectlyOrderedDesc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + (customerId + 1) + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + sellerId + "/followers/list?order=name_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[1].user_id")
                        .value(customerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id")
                        .value(customerId + 1));
    }

    @Test
    @DisplayName("11 - Get followed of customer default order comes correctly")
    public void getFollowedCustomerDefaultOrderComesCorrectly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + (sellerId + 1)));
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + customerId + "/followed/list"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_id")
                        .value(sellerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_id")
                        .value(sellerId + 1));
    }

    @Test
    @DisplayName("12 - Get followed of customer default order comes correctly")
    public void getFollowedCustomerDescOrderComesCorrectly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + (sellerId + 1)));
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + customerId + "/followed/list?order=name_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_id")
                        .value(sellerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_id")
                        .value(sellerId + 1));
    }

    @Test
    @DisplayName("13 - Get followed of customer default order comes correctly")
    public void getFollowedCustomerAscOrderComesCorrectly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + sellerId));
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + customerId + "/follow/" + (sellerId + 1)));
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + customerId + "/followed/list?order=name_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_id")
                        .value(sellerId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_id")
                        .value(sellerId + 1));
    }

    @Test
    @DisplayName("14 - Followed with unknown order name fails")
    public void followedWithUnknownOrderNameFails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + customerId + "/followed/list?order=unknown"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("15 - Followers with unknown order name fails")
    public void followersWithUnknownOrderNameFails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + sellerId + "/followers/list?order=unknown"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("16 - Followers of customer fails")
    public void followersOfCustomerFails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + customerId + "/followers/list"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("16 - Followed of seller fails")
    public void followedOfSellerFails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/" + sellerId + "/followed/list"))
                .andExpect(status().isNotFound());
    }
}
