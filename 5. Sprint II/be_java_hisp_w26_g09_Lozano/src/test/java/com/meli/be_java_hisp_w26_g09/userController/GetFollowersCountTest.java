package com.meli.be_java_hisp_w26_g09.userController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class GetFollowersCountTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkASellerFollowers() throws Exception {
        String idSeller = "2";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",idSeller))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(any(Integer.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value(any(String.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(any(Integer.class)));
    }

    @Test
    void checkACustomerFollowers() throws Exception{
        getFollowersCountTest("1","The customers don't have an option for followers",200);
    }

    @Test
    void paramInvalid() throws Exception {
        getFollowersCountTest("jhs","Not same typing attribute", 400);
    }

    private void getFollowersCountTest(String param, String result, int expectedStatusCode) throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",param))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(result));
    }
}
