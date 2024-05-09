package com.sprint.socialmeli.integration.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint.socialmeli.dto.post.FollowedProductsResponseDTO;
import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.PostResponseDTO;
import com.sprint.socialmeli.dto.post.ProductDTO;
import com.sprint.socialmeli.utils.DateOrderType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    PostDTO postDtoOk;
    PostDTO postDtoBadUserId;
    Integer customerIdOK;
    Integer customerIdNotOk;
    Integer sellerIdOk;
    Integer sellerIdNotOk;
    DateOrderType orderTypeOk;
    String orderTypeNotOk;

    @BeforeEach
    void setup(){
        customerIdOK = 101;
        customerIdNotOk = 1;
        sellerIdOk = 1;
        sellerIdNotOk = 2000;
        orderTypeOk = DateOrderType.DATE_DESC;
        orderTypeNotOk = "asd";

        postDtoOk = new PostDTO(
            1,
            formatter.format(LocalDate.now().minusWeeks(1).minusDays(1)),
            new ProductDTO(
                    1,
                    "Remera",
                    "Medium",
                    "Adidas",
                    "Blue",
                    "No notes"
            ),
            1,
            100.2
        );

        postDtoBadUserId = new PostDTO(
                10000,
                formatter.format(LocalDate.now().minusWeeks(1).minusDays(1)),
                new ProductDTO(
                        1,
                        "Remera",
                        "Medium",
                        "Adidas",
                        "Blue",
                        "No notes"
                ),
                1,
                100.2
        );
    }


    // Create post - US-0005 -----------------START
    @Test
    @DisplayName("Successful post creation")
    void createPostShouldBeOk() throws Exception{
        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(postDtoOk)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(0));
    }

    @Test
    @DisplayName("Not Found post creation of user that dont exist")
    void createPostUserDontExistShouldBeNotFound() throws Exception{
        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDtoBadUserId)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    // Create post US-0005 -----------------END

    // Get followed posts - US-0006 -----------------START
    @Test
    @DisplayName("Successful get of posts of sellers followed by a user")
    void getFollowedPostsShouldBeOk() throws Exception{
        this.mockMvc.perform(get("/products/followed/{userId}/list", customerIdOK))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(customerIdOK));
    }

    @Test
    @DisplayName("Bad request get of posts of sellers followed by a user with wrong order")
    void getFollowedPostsWrongOrderShouldBeBadRequest() throws Exception{
        this.mockMvc
                .perform(get("/products/followed/{userId}/list?order={order}",
                        customerIdOK,
                        orderTypeNotOk))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Successful get of posts of sellers followed by a user with ok order")
    void getFollowedPostswithOrderShouldBeOk() throws Exception{
        this.mockMvc
                .perform(get("/products/followed/{userId}/list?order={order}",
                        customerIdOK,
                        orderTypeOk))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(customerIdOK));
    }

    @Test
    @DisplayName("Not Found get of posts of sellers followed by a user that dont exist")
    void getFollowedPostsUserDontExitsShouldBeNotFound() throws Exception{
        this.mockMvc.perform(get("/products/followed/{userId}/list", customerIdNotOk))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
    // Get followed posts US-0006 -----------------END
}
