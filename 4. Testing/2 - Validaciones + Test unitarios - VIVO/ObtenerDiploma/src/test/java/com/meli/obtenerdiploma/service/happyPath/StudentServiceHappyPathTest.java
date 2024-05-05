package com.meli.obtenerdiploma.service.happyPath;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceHappyPathTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

}
