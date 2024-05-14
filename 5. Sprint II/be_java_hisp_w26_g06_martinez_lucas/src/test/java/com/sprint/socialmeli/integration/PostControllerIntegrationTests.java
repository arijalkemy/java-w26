package com.sprint.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.ProductDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.service.post.IPostService;
import com.sprint.socialmeli.service.user.IUsersService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter objectWriter;
    static PostDTO postDTO;
    static Post post;
    static Customer customer;
    @Autowired
    IPostService postService;


    @BeforeAll
    public static void setup(){
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();


        ProductDTO productDTO = ProductDTO.builder()
                .product_id(1)
                .product_name("Silla Ergonomica")
                .color("Negro")
                .notes("Comoda")
                .type("Sillas")
                .brand("Olimpo")
                .build();

        postDTO = PostDTO.builder()
                .date("07-05-2024")
                .price(200.00)
                .category(100)
                .user_id(1)
                .product(productDTO)
                .build();
    }

    @Autowired IUsersService usersService;

    @BeforeEach
    public void setupCustomer(){
        customer = usersService.checkAndGetCustomer(101);
    }

    @Test
    @DisplayName("Test to Endpoint products/followed/{userId}/list - Posts of followed sellers")
    public void getFollowedPosts() throws Exception {

        customer.setFollowed(List.of(1)); // Hacemos que un customer siga al Seller 1

        postService.createPost(postDTO); // crear el post para el seller ID 1

        this.mockMvc.perform(get("/products/followed/{userId}/list", customer.getUser().getUserId()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(101))
                .andExpect(jsonPath("$.posts[0].product.product_name")
                        .value("Silla Ergonomica"));

    }


    @Test
    @DisplayName("Test to Endpoint products/post - Create Post")
    public void createPost() throws Exception{

        ResultActions result = mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectWriter.writeValueAsString(postDTO)));

        String expectedId = "1";
        String responseJson = result.andReturn().getResponse().getContentAsString();

        Assertions.assertEquals(expectedId, responseJson);
    }

}
