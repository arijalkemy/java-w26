package com.meli.obtenerdiploma.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegracionTests {
    @Autowired
    private MockMvc mockMvc;

    StudentDTO stu;

    @BeforeEach
    void setUp() {
        stu = TestUtilsGenerator.getStudentWith3Subjects("Pedro");
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(stu);
    }

    @Test
    @DisplayName("Test - registrar un estudiante")
    public void testRegistrarEstudiante() throws Exception{
        urlPostStudentIsOk(stu, "/student/registerStudent");
    }

    @Test
    @DisplayName("Test - obtener un estudiante por id is OK")
    public void testObtenerEstudiantePorIdIsOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 9999))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(9999));
    }

    @Test
    @DisplayName("Test - obtener un estudiante por id is BadRequest")
    public void testObtenerEstudiantePorIdIsBadRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", "ss"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test - modificar un estudiante")
    public void testModificarEstudiante() throws Exception {
        stu.setStudentName("Juan");

        urlPostStudentIsOk(stu, "/student/modifyStudent");
    }

    @Test
    @DisplayName("Test - eliminar un estudiante")
    public void testEliminarEstudiante() throws Exception {
        urlGetStudentIsOk("/student/removeStudent/{id}", 9999L);
    }

    @Test
    @DisplayName("Test - listar estudiantes")
    public void testListarEstudiantes() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    private void urlPostStudentIsOk(StudentDTO student, String url) throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadStu = writer.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON).content(payloadStu)).andDo(print())
                .andExpect(status().isOk());
    }

    private void urlGetStudentIsOk(String url, Long idStudent) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(url, idStudent))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
