package com.meli.be_java_hisp_w26_g09.userController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class getFollowedList {

    @Autowired
    MockMvc mockMvc;

    @Test
    void checkACustomerFollowed() throws Exception {
        String idCustomer = "1";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",idCustomer))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(any(Integer.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value(any(String.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed").value(any(List.class)));
    }

    @Test
    void checkASellerFollowed() throws Exception {
        getFollowedListTest("2","The seller does not have the option to follow",200);
    }

    @Test
    void paramInvalid() throws Exception {
        getFollowedListTest("jhs","Not same typing attribute", 400);
    }

    @Test
    void userNotFound() throws Exception {
        getFollowedListTest("100","No information was found about those followed.", 404);
    }

    private void getFollowedListTest(String userId, String resultExpected, int expectedStatusCode) throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",userId))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(resultExpected));
    }


}