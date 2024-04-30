package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegration {

    private StudentDTO studentDTO;

    static ObjectWriter writer;
    @MockBean
    StudentService studentService;
    @Autowired
    MockMvc mockMvc;


    @BeforeAll
    public static void setupWriter(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void setup(){
        this.studentDTO = new StudentDTO();
        this.studentDTO.setStudentName("Juan");
        this.studentDTO.setSubjects(new ArrayList<>(List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0))));

        studentService.create(studentDTO);
    }

    @Test
    public void registerStudent() throws Exception{

        String payload = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(payload)))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void estudianteObtenidoConExito() throws Exception {

        when(studentService.read(1L)).thenReturn(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));

    }

    @Test
    public void estudianteModificado() throws Exception{

        String payload = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(payload)))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Quitar a un estudiante de la base de datos")
    public void quitarEstudiante() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 10L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Obtiene toda la lista de la base de datos exitosamente")
    public void getListStudents() throws Exception{
        Set<StudentDTO> studentDTOS = TestUtilsGenerator.getStudentSet();
        when(studentService.getAll()).thenReturn(studentDTOS);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk());

    }


}
