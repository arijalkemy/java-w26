package org.example.be_java_hisp_w26_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.util.UtilTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProductControllerTestIntegration {


    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Verifica la creacion de un post para un determinado seller")
    void createPost() throws Exception {
        PostRequestDTO payloadDTO= UtilTest.generatePostRequestDTO();
        ObjectWriter objectWriter= new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String payloadJson= objectWriter.writeValueAsString(payloadDTO);
         mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk())
                .andReturn();
    }

    @DisplayName("Verifica que no cumple con la validacion del nombre del producto del post")
    @Test
    void createBadPost() throws Exception{
        PostRequestDTO payloadDTO= UtilTest.generatePostRequestDTO();
        payloadDTO.getProduct().setProductName("product!");//No debe contener caracteres especiales
        ObjectWriter objectWriter= new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String payloadJson= objectWriter.writeValueAsString(payloadDTO);
         mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    @DisplayName("Verifica la lista de seller de un determinado buyer, ordenado por date_asc")
    void getPostFromFollowers() throws Exception {
        int userId=456;
        String order = "date_asc";

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].user_id").value(123))
                .andExpect(jsonPath("[0].post_id"). value(2))
                .andReturn();
    }

    @DisplayName("Verifica que recibe un id inexistente")
    @Test
    void getPostFromFollowersBad() throws Exception {
        int userId=432; //usuario inexistente
        String order ="date_asc";
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

}