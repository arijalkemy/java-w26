package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.integration;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostsByFollowedUsersDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ProductDTO;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .build();
    }

    @Test
    public void followedUserPost() throws Exception{
        ProductDTO productDTO = new ProductDTO(1000, "HyperX Cloud II", "Headset", "HyperX", "Red", "Excellent noise canceling");
        PostDTO postDto = new PostDTO(2001, 1, LocalDate.now(), productDTO, 1, 2000.0);
        PostDTO postDto2 = new PostDTO(2002, 1, LocalDate.now(), productDTO, 1, 2000.0);
        List<PostDTO> expectedFollowedUsersPostDto = List.of(postDto, postDto2);
        JsonNode expectedFollowersPosts = objectMapper.convertValue(expectedFollowedUsersPostDto, JsonNode.class);

        String expectedFollowedUserPostString = writer.writeValueAsString(expectedFollowersPosts);

        String url = "/products/followed/2/list";

        MvcResult results = this.mockMvc.perform(
                        MockMvcRequestBuilders.get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(2))
                .andReturn();

        String jsonResponse = results.getResponse().getContentAsString();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode responsePostFollowers = rootNode.get("posts");
        String responseFollowersString = writer.writeValueAsString(responsePostFollowers);

        Assertions.assertEquals(expectedFollowedUserPostString, responseFollowersString);
    }
}
