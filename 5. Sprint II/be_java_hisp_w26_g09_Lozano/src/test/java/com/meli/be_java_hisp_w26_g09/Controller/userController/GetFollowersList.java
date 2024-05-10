package com.meli.be_java_hisp_w26_g09.Controller.userController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GetFollowersList {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getListFollowersACustomer() throws Exception {
        getFollowersListTest("1", "The customers don't have an option for followers", 200);
    }

    @Test
    void getListFollowersOfASellerNotExists() throws Exception {
        getFollowersListTest("1111", "No information was found about those followed.", 404);
    }

    @Test
    void paramInvalid() throws Exception {
        getFollowersListTest("jhs","Not same typing attribute", 400);
    }

    private void getFollowersListTest(String userId, String resultExpected, int expectedStatusCode) throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",userId))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(resultExpected));
    }

    @Test
    void checkASellerFollowersWithOrder() throws Exception {
        String idSellers = "2";
        String order = "name_asc";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",idSellers)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(any(Integer.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value(any(String.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").value(any(List.class)));
    }

    @Test
    void checkASellerFollowersWithOrderEmpty() throws Exception {
        String idSeller= "2";
        String order = "";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",idSeller)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(any(Integer.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value(any(String.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers").value(any(List.class)));
    }
}
