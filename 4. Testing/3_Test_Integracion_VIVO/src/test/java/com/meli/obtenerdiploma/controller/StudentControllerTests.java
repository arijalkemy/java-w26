package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Autowired
    MockMvc mockMvc;

    StudentDAO studentDAO = new StudentDAO();

    @BeforeEach
    public void createEnvironment(){
        StudentDTO studentDTO = new StudentDTO(1L,"Juan","",0.0, List.of(new SubjectDTO("Math",9.0)));
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
    @Test
    public void getStudentOk() throws Exception{
        Long id = 1L;
        mockMvc.perform(get("/student/getStudent/{id}",id)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andReturn();
    }
    @Test
    public void getStudentNotOk() throws Exception {
        Long id = 9999L;

        mockMvc.perform(get("/student/getStudent/{id}",id)).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("description").value("El alumno con Id 9999 no se encuetra registrado."))
                .andReturn();
    }
    @Test
    public void registerOk() throws Exception{
        StudentDTO student = new StudentDTO(2L,"Mayusculo","",0.0,List.of(new SubjectDTO("Estructuras",8.0)));
        ObjectMapper mapper = new ObjectMapper();

        String studentExpected = mapper.writeValueAsString(student);

        mockMvc.perform(post("/student/registerStudent")
                .contentType("application/json").content(studentExpected))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void registerNotOk() throws Exception{
        StudentDTO student = new StudentDTO(2L,"minusculo","",0.0,List.of(new SubjectDTO("Rocket",9.0)));
        ObjectMapper mapper = new ObjectMapper();

        String studentExpected = mapper.writeValueAsString(student);

        mockMvc.perform(post("/student/registerStudent")
                .contentType("application/json").content(studentExpected))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
    @Test
    public void updateOk() throws Exception{
        StudentDTO student = new StudentDTO(2L,"Adrian Newey","",0.0,List.of(new SubjectDTO("Estructuras",8.0)));
        ObjectMapper mapper = new ObjectMapper();

        String studentExpected = mapper.writeValueAsString(student);

        mockMvc.perform(post("/student/modifyStudent")
                .contentType("application/json").content(studentExpected))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void updateNotOk() throws Exception{
        StudentDTO student = new StudentDTO(2L,"adrian Newey","",0.0,List.of(new SubjectDTO("Estructuras",8.0)));
        ObjectMapper mapper = new ObjectMapper();

        String studentExpected = mapper.writeValueAsString(student);

        mockMvc.perform(post("/student/modifyStudent")
                .contentType("application/json").content(studentExpected))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
    @Test
    public void deleteOk() throws Exception{
        Long id = 1L;

        mockMvc.perform(get("/student/removeStudent/{id}",id)).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }


}
