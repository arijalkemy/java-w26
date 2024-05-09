package org.example.be_java_hisp_w26_g07.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.be_java_hisp_w26_g07.utils.UserMessageError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

        @Autowired
        private MockMvc mockMvc;
        private ObjectMapper objectMapper;
        private ObjectWriter objectWriter;

        @BeforeEach
        void setUp() {
            objectMapper = new ObjectMapper();
            objectWriter =  new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        }


        @Test
        public void followUserTest() throws Exception {
            Integer userId = 1;
            Integer followerId = 1;
            mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, followerId))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.message")
                            .value(UserMessageError.ID_CLIENT_SELLER_IS_EQUALS.getMessage()));
        }

        @Test
        public void CountFollowersUserNotFoundTest() throws Exception {
            Integer userId = 50;
            mockMvc.perform(get("/users/{userId}/followers/count", userId))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.message").value(UserMessageError.USER_NOT_FOUND.getMessage(userId)));
        }
    }

