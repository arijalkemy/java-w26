package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    public void readTest(){

        long idStudent = 1;

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);

        Mockito.when(studentDAO.findById(idStudent)).thenReturn(studentDTO);

        StudentDTO result = studentService.read(idStudent);
        Assertions.assertEquals(result.getId(),studentDTO.getId());
    }

    @Test
    public void getAllTest(){
        Set<StudentDTO> listStudentDto = new HashSet<>();
        StudentDTO studentDTO1 = new StudentDTO();
        StudentDTO studentDTO2 = new StudentDTO();
        listStudentDto.add(studentDTO1);
        listStudentDto.add(studentDTO2);
        Mockito.when(studentRepository.findAll()).thenReturn(listStudentDto);

        Set<StudentDTO> result = studentService.getAll();

        Assertions.assertEquals(result.size(),listStudentDto.size());

    }

}
