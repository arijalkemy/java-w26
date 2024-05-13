package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaControllerIntegracionTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("obtener analyzeScores test integracion")
    public void obtenerAnalyzeScoresTestIntegracion() throws Exception {

        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Pedro");
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 9999)).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json")).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(9999));
    }
}
