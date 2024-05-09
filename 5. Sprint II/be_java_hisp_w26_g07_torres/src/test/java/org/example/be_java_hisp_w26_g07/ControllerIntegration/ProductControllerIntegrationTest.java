package org.example.be_java_hisp_w26_g07.ControllerIntegration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.be_java_hisp_w26_g07.dto.products.PostRequestDto;
import org.example.be_java_hisp_w26_g07.utils.GeneratorDataTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test de Integración 002 - Creación de un Post sin los parametros validos")
    public void addBadPost() throws Exception {
        PostRequestDto post = new PostRequestDto();

        ObjectWriter objectMapper = new ObjectMapper()
                                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                                            .writer().withDefaultPrettyPrinter();

        String postJson = objectMapper.writeValueAsString(post);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON).content(postJson))
                                        .andDo(print())
                                            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test de Integración 002 - Creación de un Post con los parametros validos")
    public void addPost() throws Exception {
        PostRequestDto getPostRequestDto = GeneratorDataTest.getPostRequestDto();
        ObjectWriter objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String postJson = objectMapper.writeValueAsString(getPostRequestDto);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON).content(postJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
