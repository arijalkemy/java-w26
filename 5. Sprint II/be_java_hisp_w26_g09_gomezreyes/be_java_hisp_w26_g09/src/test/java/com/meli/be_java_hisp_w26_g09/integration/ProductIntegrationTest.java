package com.meli.be_java_hisp_w26_g09.integration;
import com.meli.be_java_hisp_w26_g09.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    void testPostCreatePost() throws Exception {
        ProductDTO product = new ProductDTO();
        product.setProductId(2);
        product.setProductName("iPhone 13 Pro");
        product.setType("Smartphone");
        product.setBrand("Apple");
        product.setColor("Graphite");
        product.setNotes("6.1-inch Super Retina XDR display");

        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(2);
        postDTO.setDate(LocalDate.parse("2024-02-03"));
        postDTO.setProduct(product);
        postDTO.setCategory(1);
        postDTO.setPrice(999.99);
        postDTO.setHasPromo(false);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testPostCreatePostInvalidUser() throws Exception {
        ProductDTO product = new ProductDTO();
        product.setProductId(2);
        product.setProductName("iPhone 13 Pro");
        product.setType("Smartphone");
        product.setBrand("Apple");
        product.setColor("Graphite");
        product.setNotes("6.1-inch Super Retina XDR display");

        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(45);
        postDTO.setDate(LocalDate.parse("2024-02-03"));
        postDTO.setProduct(product);
        postDTO.setCategory(1);
        postDTO.setPrice(999.99);
        postDTO.setHasPromo(false);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(postDTO);

        ResponseDTO responseObj = new ResponseDTO("The user_id does not exist ");
        String responseJson = objectMapper.writeValueAsString(responseObj);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(responseJson));
    }

    @Test
    void testPostCreatePostUserIsNotSeller() throws Exception {
        ProductDTO product = new ProductDTO();
        product.setProductId(2);
        product.setProductName("iPhone 13 Pro");
        product.setType("Smartphone");
        product.setBrand("Apple");
        product.setColor("Graphite");
        product.setNotes("6.1-inch Super Retina XDR display");

        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(1);
        postDTO.setDate(LocalDate.parse("2024-02-03"));
        postDTO.setProduct(product);
        postDTO.setCategory(1);
        postDTO.setPrice(999.99);
        postDTO.setHasPromo(false);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(postDTO);

        ResponseDTO responseObj = new ResponseDTO("The customer can't create posts ");
        String responseJson = objectMapper.writeValueAsString(responseObj);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(responseJson));
    }

    @Test
    void testGetFollowedUsersPostsLastTwoWeeks() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        ProductDTO product1 = new ProductDTO(
                40,
                "HyperX Cloud II Gaming Headset",
                "Headset",
                "HyperX",
                "Red",
                "7.1 Virtual Surround Sound, Memory foam ear cushions, Detachable noise-canceling microphone"
        );
        ProductDTO product2 = new ProductDTO(
                15,
                "Anker PowerCore Essential 20000 PD Portable Charger",
                "Portable Charger",
                "Anker",
                "Black",
                "20,000mAh capacity, 18W Power Delivery, Dual USB ports"
        );
        ProductDTO product3 = new ProductDTO(
                7,
                "Canon EOS R5 Mirrorless Camera",
                "Camera",
                "Canon",
                "Black",
                "45MP full-frame CMOS sensor, 8K video recording, Dual Pixel CMOS AF II"
        );
        ProductDTO product4 = new ProductDTO(
                29,
                "Sony WF-1000XM4 True Wireless Earbuds",
                "Earbuds",
                "Sony",
                "Black",
                "Industry-leading noise cancellation, V1 chip, IPX4 water resistance"
        );

        PostForListDTO post1 = new PostForListDTO(
                2,
                21,
                LocalDate.parse("2024-04-30"),
                product1,
                2,
                99.99
        );
        PostForListDTO post2 = new PostForListDTO(
                4,
                3,
                LocalDate.parse("2024-04-30"),
                product2,
                3,
                49.99
        );
        PostForListDTO post3 = new PostForListDTO(
                4,
                2,
                LocalDate.parse("2024-04-29"),
                product3,
                2,
                3499.99
        );
        PostForListDTO post4 = new PostForListDTO(
                4,
                5,
                LocalDate.parse("2024-04-29"),
                product4,
                2,
                249.99
        );
        List<PostForListDTO> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        ProductFollowedListDTO responseObj = new ProductFollowedListDTO();
        responseObj.setUserId(1);
        responseObj.setPosts(posts);

        String responseJson = objectMapper.writeValueAsString(responseObj);
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson));
    }

}
