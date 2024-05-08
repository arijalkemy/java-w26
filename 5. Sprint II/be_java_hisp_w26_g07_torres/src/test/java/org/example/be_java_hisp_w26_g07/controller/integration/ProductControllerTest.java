package org.example.be_java_hisp_w26_g07.controller.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.be_java_hisp_w26_g07.dto.products.PostDto;
import org.example.be_java_hisp_w26_g07.dto.products.PostRequestDto;
import org.example.be_java_hisp_w26_g07.utils.GeneratorDataTest;
import org.example.be_java_hisp_w26_g07.utils.UserMessageError;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    private static ObjectWriter writer;
    private static ObjectMapper mapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        mapper = new ObjectMapper();
    }

    @BeforeEach
    void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    /**
     * Test for the /products/post
     * throws ResponseEntity of ValidErrorDto and BAD_REQUEST
     */
    @Test
    @DisplayName("Add post with invalid body throws an error")
    void addPostTestInvalidBody() throws Exception {
        // Given - Arrange
        PostRequestDto postToAdd = new PostRequestDto();

        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .content(writer.writeValueAsString(postToAdd))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // Then - Assert
        response.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.message")
                                .value("Por favor corregir los siguientes datos: ")
                );
    }

    /**
     * Test for the /products/post
     * throws BadRequestException
     * with message: UserMessageError.USER_NOT_FOUND.getMessage({userId})
     */
    @Test
    @DisplayName("Add post with un-existent user")
    void addPostTestUserNotFound() throws Exception {
        // Given - Arrange
        Integer badUserId = 999;
        PostRequestDto postToAdd = GeneratorDataTest.getPostRequestDto(badUserId);

        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .content(writer.writeValueAsString(postToAdd))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // Then - Assert
        response.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.message")
                                .value(UserMessageError.USER_NOT_FOUND.getMessage(badUserId))
                );
    }

    /**
     * Test for the /products/post
     * returns ResponseEntity of PostDto and status 200-OK
     */
    @Test
    @DisplayName("Add post successfully")
    void addPostTestOk() throws Exception {
        // Given - Arrange
        PostRequestDto postToAdd = GeneratorDataTest.getPostRequestDto(1);
        PostDto expectedPostDto = GeneratorDataTest.getPostDto(postToAdd, 11);
        String expectedPostStr = writer.writeValueAsString(expectedPostDto);

        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .content(writer.writeValueAsString(postToAdd))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // Then - Assert
        MvcResult result = response.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String resultStr = result.getResponse().getContentAsString();
        Assertions.assertEquals(expectedPostStr, resultStr);
    }
}
