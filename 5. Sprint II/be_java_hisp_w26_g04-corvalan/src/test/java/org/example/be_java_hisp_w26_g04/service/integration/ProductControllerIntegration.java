package org.example.be_java_hisp_w26_g04.service.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegration {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Creacion exitosa de un post")
    public void createPostTestOk() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1);
        productDTO.setProductName("Producto de prueba");
        productDTO.setTypeProduct("Tipo de prueba");
        productDTO.setBrand("Marca de prueba");
        productDTO.setColor("Rojo");
        productDTO.setNotes("Notas de prueba");

        PostRequestDTO postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUserId(123);
        postRequestDTO.setDate(LocalDate.now());
        postRequestDTO.setCategory(100);
        postRequestDTO.setPrice(50.0);
        postRequestDTO.setProduct(productDTO);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(postRequestDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Creacion incorrecta de posteo con datos invalidos")
    public void createPostWithInvalidData() throws Exception {
        ProductDTO invalidProductDTO = new ProductDTO();
        invalidProductDTO.setProductId(1);
        invalidProductDTO.setProductName("");
        invalidProductDTO.setTypeProduct("Tipo de prueba");
        invalidProductDTO.setBrand("Caracteres especiales %#%$");
        invalidProductDTO.setColor("Rojo");
        invalidProductDTO.setNotes("Notas de prueba");

        PostRequestDTO invalidPostRequestDTO = new PostRequestDTO();
        invalidPostRequestDTO.setUserId(123);
        invalidPostRequestDTO.setDate(LocalDate.now());
        invalidPostRequestDTO.setCategory(100);
        invalidPostRequestDTO.setPrice(0.0);
        invalidPostRequestDTO.setProduct(invalidProductDTO);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(invalidPostRequestDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/123/list")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }
}
