package com.meli.be_java_hisp_w26_g09.integration;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.PostDTO;
import com.meli.be_java_hisp_w26_g09.dto.ProductDTO;


@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    final String BASE_ENDPOINT = "/products";
    
    /**
     * Target to test: /products/post
     * - 1: Body OK
     * - 2: Body No OK
     * - 3: Body Empty
     * - 4: Usert not extist
     * @throws Exception 
     */

    @Test
    @DisplayName("Test to verify that the creation of post is Succesfully with rigth Body")
    public void creationPostRightBody() throws Exception {

        //Arrange
        PostDTO postDTO = PostDTO.builder()
                          .userId(2)
                          .postId(1)
                          .date(LocalDate.now())
                          .category(2)
                          .price(1000000D)
                          .product(ProductDTO.builder()
                                    .productId(1)
                                    .productName("Camisas XL")
                                    .brand("San Diego")
                                    .color("Blanco")
                                    .type("IDK")
                                    .build())
                          .build();
        ObjectMapper objectMapper = new ObjectMapper();

        String contentBody = objectMapper.writeValueAsString(postDTO);
        RequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                                 .content(contentBody)
                                 .contentType(MediaType.APPLICATION_JSON);
        
        //Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        //Assertions
        response.andExpect(status().isOk());
        response.andExpect(jsonPath("$.message").value("Post has been created"));
    }

    @Test
    @DisplayName("Test to verify that the creation of post is Succesfully with user not exists")
    public void creationPosUserNotExist() throws Exception {

        //Arrange
        PostDTO postDTO = PostDTO.builder()
                          .userId(99)
                          .postId(1)
                          .date(LocalDate.now())
                          .category(2)
                          .price(1000000D)
                          .product(ProductDTO.builder()
                                    .productId(1)
                                    .productName("Camisas XL")
                                    .brand("San Diego")
                                    .color("Blanco")
                                    .type("IDK")
                                    .build())
                          .build();
        ObjectMapper objectMapper = new ObjectMapper();

        String contentBody = objectMapper.writeValueAsString(postDTO);
        RequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                                 .content(contentBody)
                                 .contentType(MediaType.APPLICATION_JSON);
        
        //Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        //Assertions
        response.andExpect(status().isNotFound());
        response.andExpect(jsonPath("$.message").value("The user_id does not exist"));
    }

    @Test
    @DisplayName("Test to verify that the creation of post is Not Created with invalid Body")
    public void creationPostInvalidBody() throws Exception {

        //Arrange
        PostDTO postDTO = PostDTO.builder()
                          .date(LocalDate.now())
                          .category(2)
                          .price(1000000D)
                          .product(ProductDTO.builder()
                                    .productId(1)
                                    .productName("Camisas XL")
                                    .brand("San Diego")
                                    .color("Blanco")
                                    .type("IDK")
                                    .build())
                          .build();
        ObjectMapper objectMapper = new ObjectMapper();

        String contentBody = objectMapper.writeValueAsString(postDTO);
        RequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                                 .content(contentBody)
                                 .contentType(MediaType.APPLICATION_JSON);
        
        //Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        //Assertions
        response.andExpect(status().isBadRequest());
        //response.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Post has been created"));
    }


    @Test
    @DisplayName("Test to verify that the creation of post is Not Created without Body")
    public void creationPostWithoutBody() throws Exception {

        //Arrange
        RequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                                 .contentType(MediaType.APPLICATION_JSON);
        
        //Act
        ResultActions response = this.mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        //Assertions
        response.andExpect(status().isBadRequest());
        response.andExpect(jsonPath("$.message").value("HttpMessageNotReadableException"));
    }

    /**
     * Target: /proudcts/followed/{userId}/list Optional: Request param : order: date_asc | date_desc
     * UserID: Bad type 
     * UserID: BAD
     * UserID: OK Order DESC | ASC
     * @throws Exception 
    */

    @Test
    @DisplayName("Test to verify endpoint to get Posts of followed with UserID (Integer) badType")
    public void getPostsFollowedUserIdBadType() throws Exception {
        //Arrange
        String userId = "badType";
        String order = " ";
        RequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .param("order", order);
        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());
        
        //Assertion
        response.andExpect(status().isBadRequest());
        response.andExpect(jsonPath("$.message").value("Not same typing attribute"));
    }


    @Test
    @DisplayName("Test to verify endpoint to get Posts of followed with UserID empty")
    public void getPostsFollowedUserIdBad() throws Exception {
        //Arrange
        Integer userId = -1;
        RequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                                 .contentType(MediaType.APPLICATION_JSON);

        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());

        //Assertion
        response.andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("Test to verify endpoint to get Posts of followed with UserID right ID")
    public void getPostsFollowedUserIdRightType() throws Exception {
        //Arrange
        Integer userId = 1;
        RequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                                 .contentType(MediaType.APPLICATION_JSON);

        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());
        //Assertion
        response.andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test to verify endpoint to get Posts of followed with UserID right ID and order ASC")
    public void getPostsFollowedUserIdOrderAsc() throws Exception {
        //Arrange
        Integer userId = 1;
        String order = "date_asc";
        RequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                                 .param("order", order)
                                 .contentType(MediaType.APPLICATION_JSON);

        //Act
        ResultActions response = mockMvc.perform(request);
        response.andDo(MockMvcResultHandlers.print());
        //Assertion
        response.andExpect(status().isOk());
    }
}
