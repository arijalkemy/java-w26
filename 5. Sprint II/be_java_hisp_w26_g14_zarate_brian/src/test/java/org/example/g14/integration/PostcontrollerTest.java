package org.example.g14.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.g14.dto.request.PostCreateRequestDto;
import org.example.g14.dto.response.MessageResponseDto;
import org.example.g14.utils.PostList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostcontrollerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .findAndRegisterModules()
                .writer();
    }

    @Test
    @DisplayName("Post test: create post successfully")
    public void createPostTest() throws Exception {
        MessageResponseDto messageExpected = new MessageResponseDto("Post creado exitosamente.");
        PostCreateRequestDto postCreateRequestDto = PostList.getMockedPost();

        //act
        ResultActions result = mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postCreateRequestDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(messageExpected.getMessage()));

        String obtained = result.andReturn().getResponse().getContentAsString();
        String expected = writer.writeValueAsString(messageExpected);

        //assert
        assertEquals(expected, obtained);
    }
}
