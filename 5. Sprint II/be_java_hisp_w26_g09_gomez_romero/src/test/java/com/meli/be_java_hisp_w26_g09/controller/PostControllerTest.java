package com.meli.be_java_hisp_w26_g09.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.be_java_hisp_w26_g09.dto.*;
import com.meli.be_java_hisp_w26_g09.service.IPostService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPostService postService;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("Test to create a post")
    void PostController_CreatePost_Success() throws Exception {
        PostDTO postDTO = PostDTO.builder().userId(1).date(formattedDate(2024, 4, 4))
                .product(ProductDTO.builder()
                        .productId(40)
                        .productName("HyperX Cloud II Gaming Headset")
                        .type("Headset")
                        .brand("HyperX")
                        .color("Red")
                        .notes("7.1 Virtual Surround Sound, Detachable noise-canceling microphone")
                        .build())
                .category(2)
                .price(99.99)
                .build();

        String message = "Post has been created";

        when(postService.addPost(postDTO)).thenReturn(new ResponseDTO(message));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is(message)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String expectedResponse = "{\"message\":\"" + message + "\"}";
        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Test to get followed users post for the last to weeks")
    void PostController_GetFollowedUsersPostsLastTwoWeeks_Success() throws Exception{
        ProductFollowedListDTO productFollowedListDTO = ProductFollowedListDTO.builder()
                .userId(1).posts(Arrays.asList(
                        PostForListDTO.builder()
                        .date(formattedDate(2024, 4, 30))
                        .product(
                                ProductDTO.builder()
                                        .productId(40)
                                        .productName("HyperX Cloud II Gaming Headset")
                                        .type("Headset")
                                        .brand("HyperX")
                                        .color("Red")
                                        .notes("7.1 Virtual Surround Sound, Detachable noise-canceling microphone")
                                        .build()
                        )
                        .category(2)
                        .price(99.99)
                        .userId(2)
                        .postId(21)
                        .build(),
                        PostForListDTO.builder()
                                .date(formattedDate(2024, 4, 29))
                                .product(
                                        ProductDTO.builder()
                                                .productId(15)
                                                .productName("Anker PowerCore Essential 20000 PD Portable Charger")
                                                .type("Portable Charger")
                                                .brand("Anker")
                                                .color("Black")
                                                .notes("20,000mAh capacity, 18W Power Delivery, Dual USB ports")
                                                .build()
                                )
                                .category(3)
                                .price(43.99)
                                .userId(4)
                                .postId(3)
                                .build()
                ))
                .build();

        String expectedResponse = writer.writeValueAsString(productFollowedListDTO);

        when(postService.findFollowedPostsLastTwoWeeks(1)).thenReturn(productFollowedListDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", CoreMatchers.is(productFollowedListDTO.getUserId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts.size()", CoreMatchers.is(productFollowedListDTO.getPosts().size())))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Test to get followed users post for the last to weeks order asc")
    void PostController_GetFollowedUsersPostsLastTwoWeeksOrderAsc_Success() throws Exception{
        ProductFollowedListDTO productFollowedListDTO = ProductFollowedListDTO.builder()
                .userId(1).posts(Arrays.asList(
                        PostForListDTO.builder()
                                .date(formattedDate(2024, 4, 30))
                                .product(
                                        ProductDTO.builder()
                                                .productId(40)
                                                .productName("HyperX Cloud II Gaming Headset")
                                                .type("Headset")
                                                .brand("HyperX")
                                                .color("Red")
                                                .notes("7.1 Virtual Surround Sound, Detachable noise-canceling microphone")
                                                .build()
                                )
                                .category(2)
                                .price(99.99)
                                .userId(2)
                                .postId(21)
                                .build(),
                        PostForListDTO.builder()
                                .date(formattedDate(2024, 4, 29))
                                .product(
                                        ProductDTO.builder()
                                                .productId(15)
                                                .productName("Anker PowerCore Essential 20000 PD Portable Charger")
                                                .type("Portable Charger")
                                                .brand("Anker")
                                                .color("Black")
                                                .notes("20,000mAh capacity, 18W Power Delivery, Dual USB ports")
                                                .build()
                                )
                                .category(3)
                                .price(43.99)
                                .userId(4)
                                .postId(3)
                                .build()
                ))
                .build();

        String expectedResponse = writer.writeValueAsString(productFollowedListDTO);

        when(postService.findFollowedPostsLastTwoWeeksSorted(1, "name_asc")).thenReturn(productFollowedListDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list")
                        .param("order", "name_asc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id", CoreMatchers.is(productFollowedListDTO.getUserId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts.size()", CoreMatchers.is(productFollowedListDTO.getPosts().size())))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String actualResponse = mvcResult.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    private LocalDate formattedDate(int year, int month, int day){
        LocalDate date = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
        return LocalDate.parse(formattedDate, formatter);
    }
}