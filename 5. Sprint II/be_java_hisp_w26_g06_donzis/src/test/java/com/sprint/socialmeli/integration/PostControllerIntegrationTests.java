package com.sprint.socialmeli.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.socialmeli.dto.post.PostDTO;
import com.sprint.socialmeli.dto.post.ProductDTO;
import com.sprint.socialmeli.entity.Customer;
import com.sprint.socialmeli.entity.Product;
import com.sprint.socialmeli.entity.Seller;
import com.sprint.socialmeli.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.MethodName.class)
public class PostControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private ObjectWriter objectWriter;

    private Customer customer;

    private PostDTO newPostDTO;
    private String newPayload;
    private PostDTO newerPostDTO;
    private String newerPayload;
    private PostDTO existingPostDTO;
    private String existingPayload;

    @BeforeEach
    public void setup() throws Exception {
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer()
                .withDefaultPrettyPrinter();

        existingPostDTO = new PostDTO(1,
                LocalDate.now().minusWeeks(3)
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                ProductDTO.builder().product_id(1).product_name("Silla")
                        .brand("SillaPlace").type("Sillas").color("Blanco").build(),
                10, 1500.00);

        existingPayload = objectWriter.writeValueAsString(existingPostDTO);

        newPostDTO = new PostDTO(1,
                LocalDate.now().minusWeeks(1)
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                ProductDTO.builder().product_id(1).product_name("Silla")
                        .brand("SillaPlace").type("Sillas").color("Blanco").build(),
                10, 1500.00);

        newPayload = objectWriter.writeValueAsString(newPostDTO);

        newerPostDTO = new PostDTO(1,
                LocalDate.now().minusDays(2)
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                ProductDTO.builder().product_id(1).product_name("Silla")
                        .brand("SillaPlace").type("Sillas").color("Blanco").build(),
                10, 1500.00);

        newerPayload = objectWriter.writeValueAsString(newerPostDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + 101 + "/follow/" + 1));
    }

    @AfterEach
    public void tearDown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/" + 101 + "/unfollow/" + 1));
    }

    @Test
    public void testPostCreationSuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newPayload))
                .andDo(print()).andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(existingPayload));

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newerPayload));
    }

    @Test
    public void testPostFromLastTwoWeeksCorrectly() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" +
                101 + "/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.posts.size()").value(2))
                .andExpect(jsonPath("$.posts[0].post_id").value(0))
                .andExpect(jsonPath("$.posts[1].post_id").value(2));
    }

    @Test
    public void testPostFromLastTwoWeeksCorrectlyOrderAsc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" +
                        101 + "/list?order=date_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.posts.size()").value(2))
                .andExpect(jsonPath("$.posts[0].post_id").value(0))
                .andExpect(jsonPath("$.posts[1].post_id").value(2));
    }

    @Test
    public void testPostFromLastTwoWeeksCorrectlyOrderDesc() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" +
                        101 + "/list?order=date_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.posts.size()").value(2))
                .andExpect(jsonPath("$.posts[0].post_id").value(2))
                .andExpect(jsonPath("$.posts[1].post_id").value(0));
    }

    @Test
    public void testPostWithInvalidOrderTypeFails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" + 101 + "/list?order=bla"))
                .andDo(print()).andExpect(status().isBadRequest());
    }
}
