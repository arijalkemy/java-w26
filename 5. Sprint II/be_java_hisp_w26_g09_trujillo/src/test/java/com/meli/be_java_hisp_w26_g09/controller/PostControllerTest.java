package com.meli.be_java_hisp_w26_g09.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.be_java_hisp_w26_g09.dto.*;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.util.JsonUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    private static ObjectMapper objectMapper = new ObjectMapper();
    static User user = new User();
    static UserDTO userDTO = new UserDTO();
    @BeforeAll
    public static void setup() throws IOException {
        userDTO = JsonUtil.readJsonFromFile("core/dto/userDTO.json", UserDTO.class);
        user = JsonUtil.readJsonFromFile("core/entity/user.json", User.class);
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        objectMapper = new ObjectMapper();
    }


    @Test
    @DisplayName("Test for requirement US-0005")
    public void postCreatePost() throws Exception {

        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(2);
        postDTO.setDate(LocalDate.parse("2024-04-04"));

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(40);
        productDTO.setProductName("HyperX Cloud II Gaming Headset");
        productDTO.setType("Headset");
        productDTO.setBrand("HyperX");
        productDTO.setColor("Red");
        productDTO.setNotes("7.1 Virtual Surround Sound, Memory foam ear cushions");

        postDTO.setProduct(productDTO);

        postDTO.setCategory(2);
        postDTO.setPrice(99.99);

        String expectedResponse = "Post has been created";
        String postDTOJson = objectMapper.writeValueAsString(postDTO);

        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .content(postDTOJson)
                                .contentType("application/json")


                );


        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.andReturn().getResponse().getContentAsString();
        ResponseDTO responseUser = objectMapper.readValue(responseBody, ResponseDTO.class);

        assertEquals(expectedResponse, responseUser.getMessage());
    }


    @Test
    @DisplayName("Test for requirement US-0005 with error")
    public void postCreatePost1() throws Exception {

        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(2);
        postDTO.setDate(LocalDate.parse("2024-04-04"));
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(40);
        productDTO.setProductName("HyperX Cloud II Gaming Headset");
        productDTO.setType("");
        productDTO.setBrand("HyperX");
        productDTO.setColor("Red");
        productDTO.setNotes("7.1 Virtual Surround Sound, Memory foam ear cushions");

        postDTO.setProduct(productDTO);

        postDTO.setCategory(2);
        postDTO.setPrice(99.99);

        String postDTOJson = objectMapper.writeValueAsString(postDTO);
        String modifiedPostDTOJson = postDTOJson.replace("2024-04-04", "04-04-2024");

        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .content(modifiedPostDTOJson)
                                .contentType("application/json")


                );


        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test for requirement US-0006")
    public void getFollowedUsersPostsLastTwoWeeks() throws Exception {

        ProductFollowedListDTO post = new ProductFollowedListDTO();
        post.setUserId(1);

        List<PostForListDTO> posts = new ArrayList<>();

        PostForListDTO post1 = new PostForListDTO();
        post1.setUserId(4);
        post1.setPostId(2);
        post1.setDate(LocalDate.parse("2024-04-29"));

        ProductDTO product1 = new ProductDTO();
        product1.setType("Camera");
        product1.setBrand("Canon");
        product1.setColor("Black");
        product1.setNotes("45MP full-frame CMOS sensor, 8K video recording, Dual Pixel CMOS AF II");
        product1.setProductId(7);
        product1.setProductName("Canon EOS R5 Mirrorless Camera");

        post1.setProduct(product1);

        post1.setCategory(2);
        post1.setPrice(3499.99);

        posts.add(post1);

        // Crear y agregar más posts
        PostForListDTO post2 = new PostForListDTO();
        post2.setUserId(4);
        post2.setPostId(5);
        post2.setDate(LocalDate.parse("2024-04-29"));

        ProductDTO product2 = new ProductDTO();
        product2.setType("Earbuds");
        product2.setBrand("Sony");
        product2.setColor("Black");
        product2.setNotes("Industry-leading noise cancellation, V1 chip, IPX4 water resistance");
        product2.setProductId(29);
        product2.setProductName("Sony WF-1000XM4 True Wireless Earbuds");

        post2.setProduct(product2);

        post2.setCategory(2);
        post2.setPrice(249.99);

        posts.add(post2);

        // Crear y agregar más posts
        PostForListDTO post3 = new PostForListDTO();
        post3.setUserId(2);
        post3.setPostId(21);
        post3.setDate(LocalDate.parse("2024-04-30"));

        ProductDTO product3 = new ProductDTO();
        product3.setType("Headset");
        product3.setBrand("HyperX");
        product3.setColor("Red");
        product3.setNotes("7.1 Virtual Surround Sound, Memory foam ear cushions, Detachable noise-canceling microphone");
        product3.setProductId(40);
        product3.setProductName("HyperX Cloud II Gaming Headset");

        post3.setProduct(product3);

        post3.setCategory(2);
        post3.setPrice(99.99);

        posts.add(post3);

        // Crear y agregar más posts
        PostForListDTO post4 = new PostForListDTO();
        post4.setUserId(4);
        post4.setPostId(3);
        post4.setDate(LocalDate.parse("2024-04-30"));

        ProductDTO product4 = new ProductDTO();
        product4.setType("Portable Charger");
        product4.setBrand("Anker");
        product4.setColor("Black");
        product4.setNotes("20,000mAh capacity, 18W Power Delivery, Dual USB ports");
        product4.setProductId(15);
        product4.setProductName("Anker PowerCore Essential 20000 PD Portable Charger");

        post4.setProduct(product4);

        post4.setCategory(3);
        post4.setPrice(49.99);

        posts.add(post4);

        post.setPosts(posts);
        
        String order = "date_asc";
        Integer userId = 1;

        ResultActions result =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/{userId}/list",userId)
                                .param("order",order)
                                .contentType("application/json")
                );


        result.andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.andReturn().getResponse().getContentAsString();
        ProductFollowedListDTO responseUser = objectMapper.readValue(responseBody, ProductFollowedListDTO.class);

        assertEquals(post, responseUser);
    }



}