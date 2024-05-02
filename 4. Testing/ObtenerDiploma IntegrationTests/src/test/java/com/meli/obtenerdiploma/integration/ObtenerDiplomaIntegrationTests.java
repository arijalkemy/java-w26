package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();

    }

    @Test
    public void obtenerDiplomaIntegration() throws Exception {
        //arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        stu.setId(1L);
        TestUtilsGenerator.appendNewStudent(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"));
    }
    @Test
    public void studentNotFoundReturns404() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 12318L ))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"));
    }
}
