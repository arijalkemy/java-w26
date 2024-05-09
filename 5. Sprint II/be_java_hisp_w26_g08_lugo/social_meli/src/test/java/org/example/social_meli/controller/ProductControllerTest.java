package org.example.social_meli.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final int MIN_ID = 206;
    private final Set<Integer> generatedIds = new HashSet<>();
    private final Random random = new Random();

    private int generateUniquePostId() {
        int postId;
        do {
            postId = MIN_ID + random.nextInt(Integer.MAX_VALUE - MIN_ID);
        } while (!generatedIds.add(postId));
        return postId;
    }

    @Test
    @DisplayName("Debería crear un post de un producto")
    public void postProductPostTest() throws Exception {
        ProductDTO productDTO = ProductDTO.builder()
                .productId(62)
                .productName("Headset RGB Inalámbrico")
                .type("Gamer")
                .brand("Razer")
                .color("Green with RGB")
                .notes("Sin Batería")
                .build();

        PostDTO postDTO = PostDTO.builder()
                .userId(5)
                .postId(generateUniquePostId())
                .date(LocalDate.of(2021, 4, 1))
                .product(productDTO)
                .category(120)
                .price(2800.69)
                .build();

        String url = "/products/post";
        String postJson = new ObjectMapper().writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType("application/json")
                        .content(postJson))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería enviar una excepción de conflicto")
    public void postExistentProductPostTest() throws Exception{
        ProductDTO productDTO = ProductDTO.builder()
                .productId(62)
                .productName("Headset RGB Inalámbrico")
                .type("Gamer")
                .brand("Razer")
                .color("Green with RGB")
                .notes("Sin Batería")
                .build();

        PostDTO postDTO = PostDTO.builder()
                .userId(5)
                .postId(1)
                .date(LocalDate.of(2021, 4, 1))
                .product(productDTO)
                .category(120)
                .price(2800.69)
                .build();

        String url = "/products/post";
        String expected = "{" +
                "\"message\":\"Ya existe un post con el id 1\"}";
        String postJson = new ObjectMapper().writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType("application/json")
                        .content(postJson))
                .andDo(print())
                .andExpect(content().string(expected))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Debería enviar una excepción de validación")
    public void postWrongProductPostTest() throws Exception{
        ProductDTO productDTO = ProductDTO.builder()
                .productId(62)
                .productName("Headset RGB Inalámbrico")
                .type("Gamer")
                .brand("Razer")
                .color("Green with RGB")
                .notes("Sin Batería")
                .build();

        PostDTO postDTO = PostDTO.builder()
                .userId(2)
                .postId(100)
                .date(LocalDate.of(2021, 4, 1))
                .product(productDTO)
                .category(-120)
                .price(2800.69)
                .build();

        String url = "/products/post";
        String expected = "{\"category\":\"El id de categorÃ\u00ADa debe ser positivo\"}";

        String postJson = new ObjectMapper().writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType("application/json")
                        .content(postJson))
                .andDo(print())
                .andExpect(content().string(expected))
                .andExpect(status().is4xxClientError());
    }


    @Test
    @DisplayName("Debería obtener los post de los seguidos por un usuario")
    public void getSellersPostsFollowedByUserTest() throws Exception {
        Integer userId = 1;
        String url = String.format("/products/followed/%d/list", userId);
        String expectedResponse =
                "{\"userId\":1," +
                        "\"post\":[{\"postId\":16,\"userId\":5," +
                        "\"date\":\"02-05-2024\",\"product\"" +
                        ":{\"productId\":62,\"productName\":\"Headset RGB InalÃ¡mbrico\",\"type\":\"Gamer\",\"brand\":" +
                        "\"Razer\",\"color\":\"Green with RGB\",\"notes\":\"Sin BaterÃ\u00ADa\"},\"category\":120,\"price\":2800.69}," +
                        "{\"postId\":30,\"userId\":5,\"date\":\"01-05-2024\",\"product\":{\"productId\":62,\"productName\":\"" +
                        "Headset RGB InalÃ¡mbrico\",\"type\":\"Gamer\",\"brand\":\"Razer\",\"color\":\"Green with RGB\",\"notes\":\"Sin BaterÃ\u00ADa\"}," +
                        "\"category\":120,\"price\":2800.69}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería crear un post de un producto")
    public void getOrderedAscSellersPostsFollowedByUser() throws Exception {
        Integer userId = 1;
        String orderBy = "date_asc";

        String url = String.format("/products/followed/%d/list?order=%s", userId, orderBy);

        String expectedResponse =
                "{\"userId\":1," +
                        "\"post\":[{\"postId\":30,\"userId\":5," +
                        "\"date\":\"01-05-2024\",\"product\"" +
                        ":{\"productId\":62,\"productName\":\"Headset RGB InalÃ¡mbrico\",\"type\":\"Gamer\",\"brand\":" +
                        "\"Razer\",\"color\":\"Green with RGB\",\"notes\":\"Sin BaterÃ\u00ADa\"},\"category\":120,\"price\":2800.69}," +
                        "{\"postId\":16,\"userId\":5,\"date\":\"02-05-2024\",\"product\":{\"productId\":62,\"productName\":\"" +
                        "Headset RGB InalÃ¡mbrico\",\"type\":\"Gamer\",\"brand\":\"Razer\",\"color\":\"Green with RGB\",\"notes\":\"Sin BaterÃ\u00ADa\"}," +
                        "\"category\":120,\"price\":2800.69}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Debería crear un post de un producto")
    public void getOrderedDescSellersPostsFollowedByUser() throws Exception{
        Integer userId = 1;
        String orderBy = "date_desc";

        String url = String.format("/products/followed/%d/list?order=%s", userId, orderBy);

        String expectedResponse =
                "{\"userId\":1," +
                        "\"post\":[{\"postId\":16,\"userId\":5," +
                        "\"date\":\"02-05-2024\",\"product\"" +
                        ":{\"productId\":62,\"productName\":\"Headset RGB InalÃ¡mbrico\",\"type\":\"Gamer\",\"brand\":" +
                        "\"Razer\",\"color\":\"Green with RGB\",\"notes\":\"Sin BaterÃ\u00ADa\"},\"category\":120,\"price\":2800.69}," +
                        "{\"postId\":30,\"userId\":5,\"date\":\"01-05-2024\",\"product\":{\"productId\":62,\"productName\":\"" +
                        "Headset RGB InalÃ¡mbrico\",\"type\":\"Gamer\",\"brand\":\"Razer\",\"color\":\"Green with RGB\",\"notes\":\"Sin BaterÃ\u00ADa\"}," +
                        "\"category\":120,\"price\":2800.69}]}";

        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(content().string(expectedResponse))
                .andExpect(status().isOk());
    }

}