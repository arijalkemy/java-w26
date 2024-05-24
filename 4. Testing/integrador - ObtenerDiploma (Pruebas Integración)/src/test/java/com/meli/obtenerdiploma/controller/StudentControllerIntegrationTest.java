package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    IStudentService studentService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("")
    public void getStudentTest() throws Exception{

        long id = 1L;

        String url = "/student/getStudent/" + id;

        mockMvc.perform(MockMvcRequestBuilders.get(url)

                .content("application/json"))
                .andDo(print())
                .andExpect(content().string(
                        "{\"id\":1,\"studentName\":\"Anibal\",\"message\":null," +
                                "\"averageScore\":null,\"subjects\":[{\"name\":\"Kahoot\",\"score\":9.0}," +
                                "{\"name\":\"Musica\",\"score\":9.0},{\"name\":\"POO\",\"score\":10.0}]" +
                                "}"
                )).andExpect(status().isOk());
    }


}