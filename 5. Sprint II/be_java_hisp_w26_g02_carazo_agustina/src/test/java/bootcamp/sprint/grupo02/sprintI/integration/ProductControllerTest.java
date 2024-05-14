package bootcamp.sprint.grupo02.sprintI.integration;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import bootcamp.sprint.grupo02.sprintI.model.Buyer;
import bootcamp.sprint.grupo02.sprintI.model.Post;
import bootcamp.sprint.grupo02.sprintI.model.Seller;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;


    public static final String PRODUCT_URI = "/products";

    @BeforeAll
    public static void init() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    public void getPostByEqualsToZeroId() throws Exception {
       PostDTO postDTO = TestGeneratorUtil.createPostDto(0);
        String json = writer.writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post(PRODUCT_URI+"/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].message")
                        .value("El Id debe ser mayor a cero"))
                .andReturn();
    }

    @Test
    public void createPostTest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDto(1);
        String json = writer.writeValueAsString(postDTO);
        mockMvc.perform(MockMvcRequestBuilders.post(PRODUCT_URI+"/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        .value("Ok"));

    }

    @Test
    public void getPostBuyerNotExist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(PRODUCT_URI+"/followed/"+
                        999+"/list?order=" + "date_asc"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        .value("Buyer not found"))
                .andReturn();
    }

}
