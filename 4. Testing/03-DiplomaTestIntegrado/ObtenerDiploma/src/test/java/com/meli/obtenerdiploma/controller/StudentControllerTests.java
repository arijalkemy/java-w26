package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;

import static com.meli.obtenerdiploma.util.TestUtilsGenerator.getStudentSetIntegration;
import static com.meli.obtenerdiploma.util.TestUtilsGenerator.getStudentWithId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerTests {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        TestUtilsGenerator.writeUsersFile();
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

    @Test
    @DisplayName("Get Student Integration Test")
    public void getStudentIntegrationTest() throws Exception {
        Long studentId = 1L;
        StudentDTO studentExpected = getStudentWithId(studentId);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String jsonStudent = writer.writeValueAsString(studentExpected);

        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/getStudent/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(studentExpected)))
                .andReturn();

    }

    @Test
    @DisplayName("Get Remove Student Integration Test")
    public void removeStudentIntegrationTest() throws Exception{
        Long studentId = 1L;

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                            .andExpect(status().isOk())
                            .andExpect(MockMvcResultMatchers.content().string(""))
                            .andReturn();
    }

    @Test
    @DisplayName("List Students Integration Test")
    public void removeListStudentsIntegrationTest() throws Exception{

        Set<StudentDTO> expectedSet = getStudentSetIntegration();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String setJson = writer.writeValueAsString(expectedSet);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                                    .get("/student/listStudents"))
                            .andExpect(status().isOk())
                            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                            .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedSet)))
                            .andReturn();
    }

    @Test
    @DisplayName("Register Student Integration Test")
    public void registerStudentIntegrationTest() throws Exception{
        StudentDTO student = getStudentWithId(3L);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentJson = writer.writeValueAsString(student);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                                            .post("/student/registerStudent", studentJson)
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(studentJson))
                                    .andExpect(status().isOk())
                                    .andReturn();

    }

    @Test
    @DisplayName("Modify Student Integration Test")
    public void modifyStudentIntegrationTest() throws Exception{
        StudentDTO student = getStudentWithId(3L);
        student.setStudentName("Modificado");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentJson = writer.writeValueAsString(student);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                                    .post("/student/modifyStudent", studentJson)
                                    .contentType(MediaType.APPLICATION_JSON).content(studentJson))
                                .andExpect(status().isOk())
                                .andReturn();
    }

    @Test
    @DisplayName("Register Student Blank Name Integration Test")
    public void registerStudentIntegrationTestBlankName() throws Exception{
        StudentDTO student = getStudentWithId(3L);
        student.setStudentName("");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentJson = writer.writeValueAsString(student);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/student/registerStudent", studentJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().is4xxClientError())
                .andReturn();

    }

    @Test
    @DisplayName("Register Student Minus Name Integration Test")
    public void registerStudentIntegrationTestNotMayusName() throws Exception{
        StudentDTO student = getStudentWithId(3L);
        student.setStudentName("juan");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentJson = writer.writeValueAsString(student);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/student/registerStudent", studentJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().is4xxClientError())
                .andReturn();

    }

}
