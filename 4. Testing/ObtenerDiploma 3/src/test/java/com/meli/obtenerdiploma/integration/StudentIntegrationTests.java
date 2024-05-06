package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class StudentIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    private StudentDTO studentDTO;
    private ObjectWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void testRegisterStudent() throws Exception {
        studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Tomas");

        registerStudent(studentDTO);
    }

    private void registerStudent(StudentDTO studentDTO) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(studentDTO)))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetStudent() throws Exception {
        studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Tomas");

        registerStudent(studentDTO);

        studentDTO.setId(1L);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(writer.writeValueAsString(studentDTO)))
                .andReturn();
    }

    @Test
    public void testGetStudentWithInvalidId() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/1"))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 1 no se encuetra registrado."));
    }

    @Test
    public void testModifyStudent() throws Exception {
        studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Tomas");

        registerStudent(studentDTO);

        studentDTO.setStudentName("Pablo");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(writer.writeValueAsString(studentDTO)))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testModifyStudentNonExistentStudent() throws Exception {
        studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Tomas");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(studentDTO)))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testRemoveExistentStudentById() throws Exception {
        studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Tomas");

        registerStudent(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/1"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testRemoveNonExistentStudentById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/1"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetListStudents() throws Exception {
        Set<StudentDTO> allStudents = TestUtilsGenerator.getStudentSet();

        registerStudents(allStudents);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(writer.writeValueAsString(allStudents)))
                .andReturn();
    }

    private void registerStudents(Set<StudentDTO> allStudents) throws Exception {
        int cont = 1;
        for(StudentDTO student : allStudents) {
            student.setId((long) cont);
            registerStudent(student);
            cont++;
        }

    }

    @Test
    public void testGetEmptyListStudents() throws Exception {
        Set<StudentDTO> allStudents = new HashSet<>();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(writer.writeValueAsString(allStudents)))
                .andReturn();
    }
}
