package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.meli.obtenerdiploma.util.TestUtilsGenerator.getStudentWith3Subjects;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    private ObjectWriter writer;

    /*@AfterAll
    public static void cleanDB() {

    }*/

    @BeforeEach
    public void setup() {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("Registrar un estudiante válido debe registrarlo con éxito.")
    public void registerStudentOutput() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        String payloadJSON = writer.writeValueAsString(student);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().contentTypeCompatibleWith("application/json"));
    }

    @Test
    @DisplayName("Registrar un estudiante sin nombre no debe registrarlo.")
    public void registerStudentWithEmptyNameOutput() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("");
        String payloadJSON = writer.writeValueAsString(student);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.description")
                        .value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    @DisplayName("Obtener un estudiante existente")
    public void getExistingStudentTest() throws Exception {
        Long studentId = 1L;
        StudentDTO expectedStudent = new StudentDTO(studentId, "Juan", null, null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId)
        );

        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedStudent)));

        //String response = result.andReturn().getResponse().getContentAsString();
        //Assertions.assertEquals(expectedStudent, response);
    }

    @Test
    @DisplayName("No se puede obtener un estudiante inexistente")
    public void getNonExistingStudentTest() throws Exception {
        Long studentId = 5L;
        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId)
        );

        result.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.description")
                        .value("El alumno con Id 5 no se encuetra registrado."));
    }

    @Test
    @DisplayName("Modificar un estudiante")
    public void modifyStudentTest() throws Exception {
        Long studentId = 2L;
        StudentDTO studentToModify = new StudentDTO(studentId, "Juan", "Felicidades!", 10.0,
                List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 10.0),
                        new SubjectDTO("Química", 10.0)
                )
        );

        // Modify Student
        String payloadJSON = writer.writeValueAsString(studentToModify);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON))
                .andDo(print())
                .andExpect(status().isOk());

        // Validate with database
        var resultInDatabase = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId)
        );

        resultInDatabase.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(studentToModify)));

    }

    @Test
    @DisplayName("Modificar un estudiante inexistente")
    public void modifyNonExistingStudentTest() throws Exception {
        Long studentId = 10L;
        StudentDTO studentToModify = new StudentDTO(studentId, "Carlos", "Puedes mejorar!", 6.0,
                List.of(
                        new SubjectDTO("Química", 6.0)
                )
        );

        // Modify Student
        String payloadJSON = writer.writeValueAsString(studentToModify);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON))
                .andDo(print())
                .andExpect(status().isOk());

        // Validate with database
        var resultInDatabase = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId)
        );

        resultInDatabase.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.description")
                        .value("El alumno con Id 10 no se encuetra registrado."));
    }

    @Test
    @DisplayName("Eliminar estudiante")
    public void removeStudentTest() throws Exception {
        Long studentId = 300L;
        StudentDTO student = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marcos");
        String payloadJSON = writer.writeValueAsString(student);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON));

        List<StudentDTO> expectedStudents = new ArrayList<>();
        var result = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/removeStudent/{id}", studentId)
        );

        result.andDo(print())
                .andExpect(status().isOk());

        // Validate with database
        var resultInDatabase = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/student/getStudent/{id}", studentId)
        );

        resultInDatabase.andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.description")
                        .value("El alumno con Id 300 no se encuetra registrado."));

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
}
