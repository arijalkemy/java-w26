package com.testing.obtenerdiploma_unit_mocks.service;

import com.testing.obtenerdiploma_unit_mocks.model.StudentDTO;
import com.testing.obtenerdiploma_unit_mocks.repository.IStudentRepository;
import com.testing.obtenerdiploma_unit_mocks.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void create() {

//        StudentDTO studentDTO = new StudentDTO(
//                0L,
//                "",
//                "",
//                0.0,
//                new ArrayList<>()
//        );
//        this.studentService.create(studentDTO);
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