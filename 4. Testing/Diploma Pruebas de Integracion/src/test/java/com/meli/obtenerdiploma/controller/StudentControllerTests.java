package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

   StudentDAO studentDAO = new StudentDAO();

    @BeforeEach
    void setUp() {
        StudentDTO studentDTO = new StudentDTO(1L,"Juanito Perez","",0.0,
                Arrays.asList(new SubjectDTO("Español",8.0),
                        new SubjectDTO("Ingles",10.0)));
        studentDAO.save(studentDTO);
    }

    @Test
    public void registerStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.registerStudent(stu);

        // assert
        verify(service, atLeastOnce()).create(stu);
    }

    @Test
    public void getStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.read(stu.getId())).thenReturn(stu);

        // act
        StudentDTO readStu = controller.getStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void modifyStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.modifyStudent(stu);

        // assert
        verify(service, atLeastOnce()).update(stu);
    }

    @Test
    public void removeStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.removeStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void listStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(service.getAll()).thenReturn(students);

        // act
        Set<StudentDTO> readStudents = controller.listStudents();

        // assert
        verify(service, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }

    @DisplayName("Crear un nuevo estudiante sin una lista de materias")
    @Test
    public void subjectListNull() throws JsonProcessingException {
        StudentDTO student = new StudentDTO(100L, "Juanito", "", 0.0, new ArrayList<>());
        String typeError = "MethodArgumentNotValidException";

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(student);

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(payloadJson)).andDo(print()).andExpect(status().isBadRequest())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").
                            value(typeError));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Crear un nuevo estudiante sin nombre")
    @Test
    public void createStudentWitoutName() throws JsonProcessingException {
        StudentDTO student = new StudentDTO(100L, null, "", 0.0, new ArrayList<>());
        String typeError = "MethodArgumentNotValidException";

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(student);

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(payloadJson)).andDo(print()).andExpect(status().isBadRequest())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").
                            value(typeError));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Crear un nuevo estudiante error json")
    @Test
    public void createNewStudentErrorJson() throws JsonProcessingException {
        String json = "{\"studentName\": \"Juan\",}";

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)).andDo(print()).andExpect(status().isBadRequest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Crear un nuevo estudiante")
    @Test
    public void createNewStudent() throws JsonProcessingException {
        StudentDTO student = new StudentDTO(55L, "Pablito", "", 0.0, Arrays.asList(new SubjectDTO("Español",10.0)));

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(student);

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson)).andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Obtener a un estudiante")
    @Test
    public void getStudentById() throws JsonProcessingException {
        Long id = 1L;

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",String.valueOf(id))
                    .contentType(MediaType.APPLICATION_JSON)
                    ).andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Obtener a un estudiante que no existe")
    @Test
    public void getStudentBNotExistyId() throws JsonProcessingException {
        Long id = 150L;

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",String.valueOf(id))
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print()).andExpect(status().isNotFound());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Eliminar estudiante")
    @Test
    public void deleteStudent() {
        Long id = 1L;

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",String.valueOf(id))
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Listar estudiantes")
    @Test
    public void listStudent() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print()).andExpect(status().isOk());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
