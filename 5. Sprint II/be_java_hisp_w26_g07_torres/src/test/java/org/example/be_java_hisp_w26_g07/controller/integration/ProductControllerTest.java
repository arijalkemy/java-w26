package org.example.be_java_hisp_w26_g07.controller.integration;

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

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @BeforeEach
    void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(MockMvcResultHandlers.print())
                .build();
    }

    /**
     * Test for non-existent route
     * throws NotFoundException
     */
    @Test
    @DisplayName("Get NotFound exception with invalid endpoint")
    void invalidEndpointTest() throws Exception {
        // Given - Arrange
        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/non/existent/route")
        );

        // Then - Assert
        response.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Test for the /products/post
     * ValidErrorDto
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
     * returns PostDto
     */
    @Test
    @DisplayName("Error with MessageNotReadableException")
    void addPostTestMessageNotReadable() throws Exception {
        // Given - Arrange
        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .content("Invalid body format")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // Then - Assert
        response.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.message")
                                .value("Formato no valido")
                );
    }

    /**
     * Test for the /products/post
     * returns PostDto
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

    /**
     * Test for the /products/followed/{userId}/list
     * throws ConstraintValidationException
     */
    @Test
    @DisplayName("Error with the posts list due to null user id")
    void postsListInvalidUser() throws Exception {
        // Given - Arrange
        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", -29)
        );

        // Then - Assert
        response.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(
                MockMvcResultMatchers.jsonPath("$.message")
                        .value("Por favor corregir los siguientes datos: ")
        );
    }

    /**
     * Test for the /products/followed/{userId}/list
     * throws ConstraintValidationException
     */
    @Test
    @DisplayName("Error with the posts list due to non-numeric user id")
    void postsListNotANumber() throws Exception {
        // Given - Arrange
        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", "something")
        );

        // Then - Assert
        response.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.message")
                                .value("El valor ingresado en la ruta debe ser numérico")
                );
    }

    /**
     * Test for the /products/followed/{userId}/list
     * throws ConstraintValidationException
     */
    @Test
    @DisplayName("Error with the posts list with message not readable")
    void postsListMessageNotReadable() throws Exception {
        // Given - Arrange
        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                        .accept(MediaType.APPLICATION_FORM_URLENCODED)
        );

        // Then - Assert
        response.andExpect(MockMvcResultMatchers.status().isNotAcceptable());
    }

    /**
     * Test for the /products/followed/{userId}/list
     * throws NotFoundException
     */
    @Test
    @DisplayName("Error with the posts list user does not exist")
    void postsListUserNotFound() throws Exception {
        // Given - Arrange
        // When - Act
        ResultActions response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/products/followed/{userId}/list", 999)
        );

        // Then - Assert
        response.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.message")
                                .value(UserMessageError.USER_NOT_FOUND.getMessage(999))
                );
    }
}
