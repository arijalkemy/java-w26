package bootcamp.sprint.grupo02.sprintI.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter WRITER;
    private static final String PRODUCT_URI = "/products/%s";

    @BeforeAll
    public static void init() {
        WRITER = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void givenUserId_getPostsByBuyer_thenListPostWithAscOrder() throws Exception {
        PostListByBuyerResponseDTO expected = TestGeneratorUtil.createPostListByBuyerResponseDTO();

        String expectedResultJson = WRITER.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get(buildUrl("followed/1/list?order=date_asc")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(expectedResultJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void givenNegativeUserId_getPostsByBuyer_thenBadRequest() throws Exception {
        int negativeId = -1;

        this.mockMvc
                .perform(MockMvcRequestBuilders.get(buildUrl("followed/{userId}/list"), negativeId)
                        .param("order", "DATE_ASC"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value("El Id debe ser mayor a cero"));
    }

    @Test
    void givenCorrectPost_whenCreate_then200MessageOk() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDtoWithId(1);

        String payloadJson = WRITER.writeValueAsString(postDTO);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders.post(buildUrl("post"))
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Ok"));
    }

    @Test
    void givenZeroId_whenCreatePost_thenBadRequest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDtoWithId(0);
        executePostTestWithError(postDTO, "El Id debe ser mayor a cero");
    }

    @Test
    void givenNullId_whenCreatePost_thenBadRequest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDtoWithId(0);
        postDTO.setUserId(null);
        executePostTestWithError(postDTO, "El id no puede estar vacio");
    }

    @Test
    void givenNoDate_whenCreatePost_thenBadRequest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDtoWithId(1);
        postDTO.setDate("");
        executePostTestWithError(postDTO, "La fecha no puede estar vacia");
    }

    @Test
    void givenNoCategory_whenCreatePost_thenBadRequest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDtoWithId(1);
        postDTO.setCategory(null);
        executePostTestWithError(postDTO, "El campo no puede estar vacio");
    }

    @Test
    void givenNoPrice_whenCreatePost_thenBadRequest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDtoWithId(1);
        postDTO.setPrice(null);
        executePostTestWithError(postDTO, "El campo no puede estar vacio");
    }

    @Test
    void givenOverMaxPrice_whenCreatePost_thenBadRequest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDtoWithId(1);
        postDTO.setPrice(10000001D);
        executePostTestWithError(postDTO, "El precio maximo por producto es de 10.000.000");
    }

    private void executePostTestWithError(PostDTO postDTO, String message) throws Exception {
        String payloadJson = WRITER.writeValueAsString(postDTO);

        this.mockMvc
                .perform(
                        MockMvcRequestBuilders.post(buildUrl("post"))
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value(message))
                .andReturn();
    }

    private String buildUrl(String path) {
        return String.format(PRODUCT_URI, path);
    }

}
