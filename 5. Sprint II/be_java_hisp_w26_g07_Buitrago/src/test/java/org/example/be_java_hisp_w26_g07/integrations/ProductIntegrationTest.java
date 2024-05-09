package org.example.be_java_hisp_w26_g07.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private ObjectWriter objectWriter;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectWriter =  new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    }

    @Test
    @DisplayName("US-0006: Mostrar post de vendedores que sigue un usuario publicados en las ultimas dos semanas")
    public void findProductByFollowTest() throws Exception {
        Integer userId = 2;
        String expectedJson = "[{\"user_id\":3,\"post_id\":7,\"date\":\"06-05-2024\",\"product\":{\"product_id\":7,\"product_name\":\"Bookshelf\",\"type\":\"Furniture\",\"brand\":\"Furniture Co.\",\"color\":\"Cherry\",\"notes\":\"Classic bookshelf for home library\"},\"category\":3,\"price\":149.99}]";

        mockMvc.perform(get("/products/followed/{userId}/list", userId, null))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedJson));
    }


}
