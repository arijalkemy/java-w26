package com.example.sprint1.integration;

import com.example.sprint1.dto.PostDto;
import com.example.sprint1.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class PostControllerIntegration {
    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;
    private ProductDto productDto;
    private PostDto postDto;
    private String payloadJSON;

    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        productDto = new ProductDto(6, "Product Q", "Type S", "Brand Epsilon", "Yellow", "This is product Q.");
        postDto = new PostDto(6, 3, "08-05-2024", 3, 15.07, productDto);
    }

    @Test
    public void testAddPost() throws Exception{

        payloadJSON = writer.writeValueAsString(postDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddPostWithInvalidProduct() throws Exception{
        postDto.setProduct(null);
        payloadJSON = writer.writeValueAsString(postDto);

        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("name", "MethodArgumentNotValidException");
        expectedResponse.put("description", "El product no puede estar vacío.");
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testAddPostWithExistingId() throws Exception{
        postDto.setId(1);
        payloadJSON = writer.writeValueAsString(postDto);

        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("message", "A post with this ID already exists.");
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andExpect(status().isConflict())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testAddPostWithInvalidPrice() throws Exception{
        postDto.setPrice(-1.0);
        payloadJSON = writer.writeValueAsString(postDto);

        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("name", "MethodArgumentNotValidException");
        expectedResponse.put("description", "El precio mínimo es de 0.01");
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testAddPostWithInvalidDate() throws Exception{
        postDto.setDate("0823-05-01");
        payloadJSON = writer.writeValueAsString(postDto);

        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("name", "MethodArgumentNotValidException");
        expectedResponse.put("description", "La fecha debe tener el formato dd-mm-yyyy");
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testAddPostWithInvalidJSON() throws Exception{
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("name", "HttpMessageNotReadableException");
        String expectedResponseJSON = writer.writeValueAsString(expectedResponse);
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("invalidJson"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedResponseJSON));
    }

    @Test
    public void testGetPostsListFromFollowedUsers() throws Exception{
        Integer userId = 3;
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId))
                .andExpect(status().isOk());
    }

}
