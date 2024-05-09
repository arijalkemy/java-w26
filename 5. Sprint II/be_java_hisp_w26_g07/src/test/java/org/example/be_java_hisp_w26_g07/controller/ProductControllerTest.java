package org.example.be_java_hisp_w26_g07.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.be_java_hisp_w26_g07.dto.products.PostDto;
import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.service.interfaces.IProductService;
import org.example.be_java_hisp_w26_g07.utils.GeneratorDataTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    ObjectMapper objectMapper;
    ObjectWriter objectWriter;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }

    @Test
    @DisplayName("T-0006 getLatestPost unit test")
    void getLatestPostTest() throws Exception {
        // Given - Arrange
        List<Post> mockPosts = GeneratorDataTest.getListOfSellersLastTwoWeeks();
        List<PostDto> mockPostsDto = mockPosts.stream()
                .map(mp -> objectMapper.convertValue(mp, PostDto.class))
                .toList();
        Mockito.when(productService.findProductByFollow(5, "date_desc"))
                .thenReturn(mockPostsDto);
        String expectedStr = objectMapper.writeValueAsString(mockPostsDto);
        // When - Act
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/products/followed/{userId}/list", 5)
                                .param("order", "date_desc")
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        // Then - Assert
        String body = result.getResponse().getContentAsString();
        Assertions.assertEquals(expectedStr, body);
    }
}
