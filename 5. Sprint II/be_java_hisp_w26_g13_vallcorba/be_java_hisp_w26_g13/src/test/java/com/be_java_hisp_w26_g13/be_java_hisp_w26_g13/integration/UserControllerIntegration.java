package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.integration;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.MessageDto;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.UserDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @Test
    public void getFollowerListTest() throws Exception {
        String expectedFollowers = "[{\"user_id\":15,\"user_name\":\"Oscar Lee\"},{\"user_id\":2,\"user_name\":\"Bob Smith\"}]";

        String url = "/users/1/followers/list";

        MvcResult results = this.mockMvc.perform(
                        MockMvcRequestBuilders.get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Alice Morrison"))
                .andReturn();

        String jsonResponse = results.getResponse().getContentAsString();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode responseFollowers = rootNode.get("followers");
        String responseFollowersString = writer.writeValueAsString(responseFollowers);

        Assertions.assertEquals(expectedFollowers, responseFollowersString);
    }

    @Test
    public void getFollowerListBadUserId() throws Exception {
        String expectedMessage = "User with id 1345 does not exist";

        String url = "/users/1345/followers/list";

        MvcResult results = this.mockMvc.perform(
                        MockMvcRequestBuilders.get(url))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        String jsonResponse = results.getResponse().getContentAsString();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode responseMessage = rootNode.get("message");

        Assertions.assertEquals(expectedMessage, responseMessage.asText());
    }

    @Test
    public void getFollowersCount() throws Exception {
        int expectedFollowersCount = 2;
        String url = "/users/1/followers/count";

        MvcResult results = this.mockMvc.perform(
                        MockMvcRequestBuilders.get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Alice Morrison"))
                .andReturn();

        String jsonResponse = results.getResponse().getContentAsString();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode responseFollowers = rootNode.get("followers_count");

        Assertions.assertEquals(expectedFollowersCount, responseFollowers.asInt());
    }

    @Test
    public void getFollowerCountBadUserId() throws Exception {
        String expectedMessage = "User with id 1345 does not exist";

        String url = "/users/1345/followers/count";

        MvcResult results = this.mockMvc.perform(
                        MockMvcRequestBuilders.get(url))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        String jsonResponse = results.getResponse().getContentAsString();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode responseMessage = rootNode.get("message");

        Assertions.assertEquals(expectedMessage, responseMessage.asText());
    }
}