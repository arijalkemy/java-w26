package com.meli.be_java_hisp_w26_g09.userController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class unfollowUserTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void customerUnfollowSeller() throws Exception {
        unfollowUserTest("1", "2", "Unfollow successfull", 200);
    }

    @Test
    void sellerUnfollowToSeller() throws Exception {
        unfollowUserTest("2", "2", "The seller can't unfollow to a seller", 400);
    }

    @Test
    void sellerNotFollowed() throws Exception {
        unfollowUserTest("1", "3", "User not found in followers list", 404);
    }

    @Test
    void userNotExists() throws Exception {
        unfollowUserTest("1111", "3", "User not found", 404);
    }

    @Test
    void userParamInvalid() throws Exception {
        unfollowUserTest("jhs", "3", "Not same typing attribute", 400);
    }

    @Test
    void userToUnfollowParamInvalid() throws Exception {
        unfollowUserTest("1", "jhs", "Not same typing attribute", 400);
    }

    private void unfollowUserTest(String userId, String userIdToUnfollow, String resultExpected, int expectedStatusCode) throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",userId, userIdToUnfollow ))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(resultExpected));
    }




}
