package bootcamp.sprint.grupo02.sprintI.integration;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void postNewPostWhitoutUserIdReturnsMethodException() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setProduct(TestGeneratorUtil.createProductDTO());
        postDTO.setDate("2021-09-01");
        postDTO.setCategory(1);
        postDTO.setPrice(100.0);

        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(postDTO)))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

}
