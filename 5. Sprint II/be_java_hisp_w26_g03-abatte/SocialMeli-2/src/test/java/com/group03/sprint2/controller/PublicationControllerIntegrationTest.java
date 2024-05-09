package com.group03.sprint2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.group03.sprint2.dto.ProductDTO;
import com.group03.sprint2.dto.PublicationDTO;
import com.group03.sprint2.dto.response.MessageResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class PublicationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Show successfully message when create a publication")
    public void createPublicationTestOk() throws Exception {

        LocalDate fecha = LocalDate.now();

        ProductDTO productDTO = new ProductDTO(1, "producto", "tipo", "marca", "color", "notas");
        PublicationDTO publicationDTO = new PublicationDTO(1, 1001, fecha, productDTO, 5, 10.5);

        MessageResponseDTO messageResponseDTO = new MessageResponseDTO("Post created successfully.");

        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(publicationDTO);
        String responseJson = writer.writeValueAsString(messageResponseDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Should show not found exception when you try to create a publication with an invalid seller id")
    public void createPublicationNotFoundTest() throws Exception {
        LocalDate fecha = LocalDate.now();

        ProductDTO productDTO = new ProductDTO(1, "producto", "tipo", "marca", "color", "notas");
        PublicationDTO publicationDTO = new PublicationDTO(10890, 1001, fecha, productDTO, 5, 10.5);

        MessageResponseDTO messageResponseDTO = new MessageResponseDTO("There is not seller with ID: " + publicationDTO.getUserId());

        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(publicationDTO);
        String responseJson = writer.writeValueAsString(messageResponseDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson, response.getResponse().getContentAsString());
    }
}
