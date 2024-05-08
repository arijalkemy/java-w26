package bootcamp.sprint.grupo02.sprintI.integration;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.util.TestGeneratorUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter objectWriter;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectWriter = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @Test
    public void getPostByUserTest() throws Exception {
        PostListByBuyerResponseDTO expectedResult = TestGeneratorUtil.createPostListByBuyerResponseDTO();

        String expectedResultJson = objectWriter.writeValueAsString(expectedResult);

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/products/followed/1/list?order=date_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(mvcResult.getResponse().getContentAsString(), expectedResultJson);
    }

    @Test
    public void getPostByUserBuyerDoesNotExistTest() throws Exception {
        executeGetTestWithErrors(
                "Buyer not found",
                3,
                "date_asc",
                status().isNotFound(),
                "$.message"
        );
    }

    @Test
    public void getPostByUserIdEqualsZeroTest() throws Exception {
        executeGetTestWithErrors(
                "El Id debe ser mayor a cero",
                0,
                "date_asc",
                status().isBadRequest(),
                "$[0].message"
        );
    }

    @Test
    public void getPostByUserInvalidOrderTest() throws Exception {
        executeGetTestWithErrors(
                "El Orden asdasd no existe.",
                1,
                "asdasd",
                status().isBadRequest(),
                "$.message"
        );
    }

    private void executeGetTestWithErrors(String message, int id, String order, ResultMatcher resultMatcher,String expression) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" + id + "/list?order=" + order))
                .andDo(print())
                .andExpect(resultMatcher)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(expression).value(message));
    }

    @Test
    public void createPostTest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDTO(1);

        String payloadJson = objectWriter.writeValueAsString(postDTO);

        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Ok"))
                .andReturn();
    }

    @Test
    public void createPostWithIdEqualsZeroTest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDTO(0);
        executePostTestWithError(postDTO, "El Id debe ser mayor a cero");
    }

    @Test
    public void createPostWithIdNullTest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDTO(0);
        postDTO.setUserId(null);
        executePostTestWithError(postDTO, "El id no puede estar vacio");
    }

    @Test
    public void createPostWithEmptyDateTest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDTO(1);
        postDTO.setDate("");
        executePostTestWithError(postDTO, "La fecha no puede estar vacia");
    }

    @Test
    public void createPostWithEmptyCategoryTest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDTO(1);
        postDTO.setCategory(null);
        executePostTestWithError(postDTO, "El campo no puede estar vacio");
    }

    @Test
    public void createPostWithNullPriceTest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDTO(1);
        postDTO.setPrice(null);
        executePostTestWithError(postDTO, "El campo no puede estar vacio");
    }

    @Test
    public void createPostWithMaxPriceTest() throws Exception {
        PostDTO postDTO = TestGeneratorUtil.createPostDTO(1);
        postDTO.setPrice(10000001D);
        executePostTestWithError(postDTO, "El precio maximo por producto es de 10.000.000");
    }

    private void executePostTestWithError(PostDTO postDTO, String message) throws Exception {
        String payloadJson = objectWriter.writeValueAsString(postDTO);

        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].message").value(message))
                .andReturn();
    }
}
