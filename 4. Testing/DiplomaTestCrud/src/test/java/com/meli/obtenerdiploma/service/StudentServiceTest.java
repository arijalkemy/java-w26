package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
     @Mock
    StudentService studentService;

    @Test
    void createStudentWithInvalidName() {
        List<SubjectDTO> subjects = List.of( new SubjectDTO( "Carlos", 12.0) );
        StudentDTO student = new StudentDTO( (long) 1,"jose","msg",15.0,subjects );
//        Exception exception = assertThrows(Exception.class, () -> foo.foo());
//        assertEquals("Exception Message", exception.getMessage());
        assertThrows(MethodArgumentNotValidException.class, () -> studentService.create(student) );

    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}