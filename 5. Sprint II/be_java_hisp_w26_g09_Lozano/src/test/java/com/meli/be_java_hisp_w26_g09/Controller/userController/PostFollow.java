package com.meli.be_java_hisp_w26_g09.Controller.userController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostFollow {

    @Autowired
    MockMvc mockMvc;

    @Test
    void customerFollowSeller() throws Exception {
        String userId = "1";
        String userIdToFollow = "19";
        postFollowTest(userId, userIdToFollow, "The user with id " + userId + " is follow to " + userIdToFollow, 200);
    }

    @Test
    void customerFollowSellerWhoAlreadyFollowed() throws Exception {
        postFollowTest("3", "4", "The user already follow to this customer.", 400);
    }

    @Test
    void customerFollowCustomer() throws Exception {
        postFollowTest("1", "3", "Some submitted user does not comply with the role restrictions.", 400);
    }

    @Test
    void sellerNotExists() throws Exception {
        String userId = "1";
        String userIdToFollow = "22222";
        postFollowTest(userId, userIdToFollow, "The user with id " + userIdToFollow + " was not found.", 404);
    }

    @Test
    void userToFollowParamInvalid() throws Exception {
        postFollowTest("1", "asdasd", "Not same typing attribute", 400);
    }

    private void postFollowTest(String userId, String userIdToFollow, String resultExpected, int expectedStatusCode) throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",userId, userIdToFollow ))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(resultExpected));
    }
}
