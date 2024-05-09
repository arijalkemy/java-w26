package com.sprint.socialmeli.integration.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    Integer customerIdOK;
    Integer customerIdNotOk;
    Integer sellerIdOk;
    Integer sellerIdNotOk;

    @BeforeEach
    void setup(){
        customerIdOK = 101;
        customerIdNotOk = 1;
        sellerIdOk = 1;
        sellerIdNotOk = 2000;
    }

    // Post follow - US-0001 -----------------START
    @Test
    @DisplayName("Successful follow of user to userToFollow")
    void postFollowShouldBeOk() throws Exception{
        this.mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}",
                        customerIdOK,
                        sellerIdOk))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")));
    }

    @Test
    @DisplayName("Not Found follow of user to userToFollow that doesnt exist")
    void postFollowUserToFollowDontExistShouldBeNotFound() throws Exception{
        this.mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}"
                        , customerIdOK
                        , sellerIdNotOk))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    // Post follow US-0001 -----------------END

    // Get followers count - US-0002 -----------------START
    @Test
    @DisplayName("Successful get followers count")
    void getFollowersCountShouldBeOk() throws Exception{
        this.mockMvc.perform(get("/users/{userId}/followers/count", sellerIdOk))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.follower_count").value(0));
    }

    @Test
    @DisplayName("Not Found get followers count of user that dont exist")
    void getFollowersCountUserDontExistShouldBeNotFound() throws Exception{
        this.mockMvc.perform(get("/users/{userId}/followers/count", sellerIdNotOk))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    // Get followers count US-0002 -----------------END

    // Get followers list - US-0003 -----------------START
    @Test
    @DisplayName("Successful get followers list")
    void getFollowersListShouldBeOk() throws Exception{
        this.mockMvc.perform(get("/users/{userId}/followers/list", sellerIdOk))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(sellerIdOk));
    }
    // Get followers list US-0003 -----------------END

    // Get followed list - US-0004 -----------------START
    @Test
    @DisplayName("Not Found get followed list of user that dont exist")
    void getFollowedListUserDontExistShouldBeNotFound() throws Exception{
        this.mockMvc
                .perform(get("/users/{userId}/followed/list",
                        customerIdNotOk))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Successful get followed list")
    void getFollowedListShouldBeOk() throws Exception{
        this.mockMvc
                .perform(get("/users/{userId}/followed/list",
                        customerIdOK))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(customerIdOK));
    }
    // Get followed list US-0004 -----------------END

    // Post unfollow - US-0007 -----------------START
    @Test
    @DisplayName("Successful unfollow of user to userToUnfollow")
    void postUnfollowShouldBeOk() throws Exception{
        this.mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}",
                        customerIdOK,
                        sellerIdOk));

        this.mockMvc
                .perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",
                        customerIdOK,
                        sellerIdOk))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("OK")));
    }

    @Test
    @DisplayName("Bad request unfollow of user that dont follow userToUnfollow")
    void postUnfollowUserDontFollowUserToUnfollowShouldBeBadRequest() throws Exception{
        this.mockMvc
                .perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",
                        customerIdOK,
                        sellerIdOk))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    // Post unfollow US-0007 -----------------END
}
