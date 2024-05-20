package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStudentService service;

    @Test
    public void registerStudentTest() throws Exception {
        // Crear un StudentDTO de prueba
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Test Student");
        student.setAverageScore(9.5);
        student.setMessage("El alumno Test Student ha obtenido un promedio de 9.50. Felicitaciones!");

        // Crear una lista de materias y agregarla al StudentDTO
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO();
        subject.setName("Math");
        subject.setScore(9.5);
        subjects.add(subject);
        student.setSubjects(subjects);

        // Configurar Mockito para que cuando se llame a create() con el StudentDTO de prueba, no haga nada
        doNothing().when(service).create(student);

        // Realizar una solicitud POST a /student/registerStudent con el StudentDTO de prueba como cuerpo de la solicitud
        // y verificar que la respuesta tiene el estado HTTP 200 (OK)
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    public void getStudentTest() throws Exception {
        // Crear un StudentDTO de prueba
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Test Student");
        student.setAverageScore(9.5);
        student.setMessage("El alumno Test Student ha obtenido un promedio de 9.50. Felicitaciones!");

        // Configurar Mockito para devolver el StudentDTO de prueba cuando se llame a read() con el ID 1
        when(service.read(1L)).thenReturn(student);

        // Realizar una solicitud GET a /student/getStudent/1 y verificar que la respuesta tiene el estado HTTP 200 (OK)
        // y que el contenido de la respuesta es el StudentDTO esperado
        mockMvc.perform(get("/student/getStudent/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(student.getId().intValue())))
                .andExpect(jsonPath("$.studentName", is(student.getStudentName())))
                .andExpect(jsonPath("$.averageScore", is(student.getAverageScore())))
                .andExpect(jsonPath("$.message", is(student.getMessage())));
    }

    @Test
    public void modifyStudentTest() throws Exception {
        // Crear un StudentDTO de prueba
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Test Student");
        student.setAverageScore(9.5);
        student.setMessage("El alumno Test Student ha obtenido un promedio de 9.50. Felicitaciones!");

        // Crear una lista de materias y agregarla al StudentDTO
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO();
        subject.setName("Math");
        subject.setScore(9.5);
        subjects.add(subject);
        student.setSubjects(subjects);

        // Configurar Mockito para que cuando se llame a update() con el StudentDTO de prueba, no haga nada
        doNothing().when(service).update(student);

        // Realizar una solicitud POST a /student/modifyStudent con el StudentDTO de prueba como cuerpo de la solicitud
        // y verificar que la respuesta tiene el estado HTTP 200 (OK)
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    public void removeStudentTest() throws Exception {
        // Configurar Mockito para que cuando se llame a delete() con el ID 1, no haga nada
        doNothing().when(service).delete(1L);

        // Realizar una solicitud GET a /student/removeStudent/1 y verificar que la respuesta tiene el estado HTTP 200 (OK)
        mockMvc.perform(get("/student/removeStudent/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void listStudentsTest() throws Exception {
        // Crear un conjunto de StudentDTO de prueba
        Set<StudentDTO> students = new HashSet<>();
        StudentDTO student1 = new StudentDTO();
        student1.setId(1L);
        student1.setStudentName("Test Student 1");
        student1.setAverageScore(9.5);
        student1.setMessage("El alumno Test Student 1 ha obtenido un promedio de 9.50. Felicitaciones!");
        students.add(student1);

        StudentDTO student2 = new StudentDTO();
        student2.setId(2L);
        student2.setStudentName("Test Student 2");
        student2.setAverageScore(9.0);
        student2.setMessage("El alumno Test Student 2 ha obtenido un promedio de 9.00. Felicitaciones!");
        students.add(student2);

        // Configurar Mockito para devolver el conjunto de StudentDTO de prueba cuando se llame a getAll()
        when(service.getAll()).thenReturn(students);

        // Realizar una solicitud GET a /student/listStudents y verificar que la respuesta tiene el estado HTTP 200 (OK)
        // y que el contenido de la respuesta es el conjunto de StudentDTO esperado
        mockMvc.perform(get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(student1.getId().intValue())))
                .andExpect(jsonPath("$[0].studentName", is(student1.getStudentName())))
                .andExpect(jsonPath("$[0].averageScore", is(student1.getAverageScore())))
                .andExpect(jsonPath("$[0].message", is(student1.getMessage())))
                .andExpect(jsonPath("$[1].id", is(student2.getId().intValue())))
                .andExpect(jsonPath("$[1].studentName", is(student2.getStudentName())))
                .andExpect(jsonPath("$[1].averageScore", is(student2.getAverageScore())))
                .andExpect(jsonPath("$[1].message", is(student2.getMessage())));
    }
}
