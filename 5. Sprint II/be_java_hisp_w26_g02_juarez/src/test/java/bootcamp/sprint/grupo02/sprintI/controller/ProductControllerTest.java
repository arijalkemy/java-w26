package bootcamp.sprint.grupo02.sprintI.controller;

import bootcamp.sprint.grupo02.sprintI.repository.BuyerRepository;
import bootcamp.sprint.grupo02.sprintI.repository.PostRepository;
import bootcamp.sprint.grupo02.sprintI.repository.ProductRepository;
import bootcamp.sprint.grupo02.sprintI.repository.SellerRepository;
import bootcamp.sprint.grupo02.sprintI.repository.implementations.BuyerRepositoryImpl;
import bootcamp.sprint.grupo02.sprintI.repository.implementations.PostRepositoryImpl;
import bootcamp.sprint.grupo02.sprintI.repository.implementations.ProductRepositoryImpl;
import bootcamp.sprint.grupo02.sprintI.repository.implementations.SellerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("should get the posts in ascending order")
    void getPostByUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",1)
                .param("order","date_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("1"))
                .andExpect(jsonPath("$.posts[0].date").value("2024-04-30"))
                .andExpect(jsonPath("$.posts[1].date").value("2024-05-08"));
    }
}