package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentService service;

    @InjectMocks
    StudentController controller;

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

    /* sad path */
    @Test
    @DisplayName("it should return a 404 when student is not found")
    public void optenerStudent_NotFound() throws Exception{
        when(service.read(anyLong())).thenThrow(new StudentNotFoundException(anyLong()));

        ResultActions result = mockMvc.perform(
                get("/student/getStudent/{id}", -99L)
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name").value("404 NOT_FOUND"))
                .andDo(print());
    }
}
