package org.example.be_java_hisp_w26_g04.service.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.util.List;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.service.util.UtilTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .registerModule(new JavaTimeModule());

        writer = objectMapper.writer();
    }

    @Test
    @DisplayName("Crear un post")
    public void createPost() throws Exception {
        // Arrange
        PostRequestDTO post = PostRequestDTO.builder()
            .userId(123) // Must exists
            .date(LocalDate.now())
            .category(1)
            .price(1.0)
            .product(UtilTest.getProduct2())
            .build();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .post("/products/post")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(post));

        // Act & Assert
        this.mockMvc.perform(request)
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

//    @Test
//    @DisplayName("Get posts de mis seguidos retorna los posts correctos")
//    public void getPostsFromFollowerReturnsCorrectPosts() throws Exception {
//        // Arrange
//        int userId = 123;
//        String order = "date_desc";
//        List<PostResponseDTO> expectedPosts = List.of(
//            new PostResponseDTO(/* initialize fields */),
//            new PostResponseDTO(/* initialize fields */)
//        );
//
//        String expectedContent = writer.writeValueAsString(expectedPosts);
//
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
//            .get("/products/followed/{userId}/list", userId)
//            .param("order", order);
//
//        // Act
//        mockMvc
//            .perform(request)
//            .andDo(print())
//            .andExpect(status().isOk())
//            .andExpect(content().json(expectedContent))
//            .andReturn();
//    }

    @Test
    @DisplayName("Get Post devuelve una lista vacía cuando no hay posts")
    public void getPostsFromFollowerReturnsEmptyListWhenNoPosts() throws Exception {
        // Arrange
        int userId = 999;
        String order = "date_desc";
        List<PostResponseDTO> expectedPosts = List.of();

        String expectedContent = writer.writeValueAsString(expectedPosts);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .get("/products/followed/{userId}/list", userId)
            .param("order", order);

        // Act
        MvcResult result = mockMvc
            .perform(request)
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(expectedContent))
            .andReturn();

        // Then
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        assertEquals("[]", result.getResponse().getContentAsString());
    }
}
