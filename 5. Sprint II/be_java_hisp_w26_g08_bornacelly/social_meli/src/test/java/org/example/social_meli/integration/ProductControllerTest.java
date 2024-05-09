package org.example.social_meli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.social_meli.dto.ExceptionDTO;
import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.ProductDTO;
import org.junit.jupiter.api.Assertions;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Random;

@AutoConfigureMockMvc
@SpringBootTest
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;


    private static ObjectMapper objectMapper;

    private static ObjectWriter objectWriter;

    @BeforeAll
    public static void setUp(){
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Se verifica la integración del sistema en la creacion de un post")
    void postProductPostTest() throws Exception {
        //Arrange
        Random rand = new Random();

        int min = 200;
        int max = 1000;
        int postId = rand.nextInt((max - min) + 1) + min;

        ProductDTO product = new ProductDTO(1, "product A", "Type A", "Brand A", "Blue", "note");
        LocalDate postLocalDate = LocalDate.of(2024, 5, 6);
        PostDTO postDto = new PostDTO(postId, 2, postLocalDate, product, 1, 12000.0);

        //Act
        ResultActions results = mockMvc.perform(
                MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(postDto)))
                .andExpect(MockMvcResultMatchers.status().isOk()
        );

        //Asserts
        String resultString = results.andReturn().getResponse().getContentAsString();
        String expectedString = objectMapper.writeValueAsString(postDto);

        Assertions.assertEquals(expectedString, resultString);
    }

    @Test
    @DisplayName("Se debería obtener un mensaje indicando que ya existe un post con id 1")
    void postProductPostWithExistPostIdTest() throws Exception {
        //Arrange
        ProductDTO product = new ProductDTO(1, "product A", "Type A", "Brand A", "Blue", "note");
        LocalDate postLocalDate = LocalDate.of(2024, 5, 6);
        PostDTO postDto = new PostDTO(1, 2, postLocalDate, product, 1, 12000.0);

        ExceptionDTO message = new ExceptionDTO("Ya existe un post con el id 1");

        //Act
        ResultActions results = mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectWriter.writeValueAsString(postDto)))
                .andExpect(MockMvcResultMatchers.status().isConflict()
                );

        //Asserts
        String resultString = results.andReturn().getResponse().getContentAsString();
        String expectedString = objectMapper.writeValueAsString(message);
        Assertions.assertEquals(expectedString, resultString);
    }

    @Test
    @DisplayName("Se debería obtener la lista de seguidos del usuario con id 1")
    void getSellersPostsFollowedByUserTest() throws Exception {
        //Arrange
        Integer userId = 1;
        String url = String.format("/products/followed/%d/list", userId);

        //Act
        mockMvc.perform(
                MockMvcRequestBuilders.get(url))
                //Asserts
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(1)

        );
    }

    @Test
    @DisplayName("Se debería obtener la lista de seguidos del usuario con id 1")
    void getSellersPostsFollowedByUserWithParamTest() throws Exception {
        //Arrange
        Integer userId = 1;
        String url = String.format("/products/followed/%d/list", userId);

        //Act
        mockMvc.perform(
                        MockMvcRequestBuilders.get(url)
                                .param("order", "date_asc"))
                                //Asserts
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(1)
                );
    }

}