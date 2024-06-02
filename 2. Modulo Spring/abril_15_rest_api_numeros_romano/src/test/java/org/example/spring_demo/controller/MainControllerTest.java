package org.example.spring_demo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    void validateHttpOKResponse() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("III")
        );
    }

    @Test
    void validateHttpBadRequestResponse() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/4000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("Input must be between 1 and 3999")
        );
    }
}
