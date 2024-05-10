package com.javabootcamp.socialmeli.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javabootcamp.socialmeli.dto.response.ResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        objectMapper = new ObjectMapper();
    }

    @Test
    public void followUserTest() throws Exception {
        var responseBodyExpected = new ResponseDto("Follower added succesfully");
        String responseBodyExpectedString = writer.writeValueAsString(responseBodyExpected);

        //use el perform para invocar la API
        MvcResult result  = mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userToFollow}", 1, 2)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk()) //verificar estado de respuesta
                .andExpect(content().contentType("application/json")) //verificar tipo de contenido
                .andReturn();


        String responseActualString = result.getResponse().getContentAsString();

        Assertions.assertEquals(responseBodyExpectedString, responseActualString);
    }

}
