package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterStudentOk() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");

        List<SubjectDTO> subjects = List.of(new SubjectDTO("Matematicas", 7.0)
                ,new SubjectDTO("Fisica", 7.0));

        studentDTO.setSubjects(subjects);

        mockMvc.perform(post("/student/registerStudent")
                .contentType("application/json")
                        .content(toJson(studentDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterStudentBadRequest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");

        mockMvc.perform(post("/student/registerStudent")
                .contentType("application/json")
                .content(toJson(studentDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("La lista de materias no puede estar vacía."));
    }

    @Test
    public void testGetStudentOk() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 3))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName")
                        .value("Juan"));
    }

    @Test
    public void testGetStudentNotFound() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 100))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El alumno con Id 100 no se encuetra registrado."));
    }

    @Test
    public void testRemoveStudentOk() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}", 1))
                .andExpect(status().isOk());
    }

    //Convertir a byte studentDto
    private byte[] toJson(StudentDTO studentDTO) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsBytes(studentDTO);
    }
}