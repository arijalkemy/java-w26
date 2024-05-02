package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(value = MockitoExtension.class)
public class StudentServiceTests {

    //Creo mock de IStudentDAO
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository iStudentRepository;

    @InjectMocks
    private StudentService studentService;

    private StudentDTO studentDTOUno;
    private StudentDTO studentDTODos;

    //Configurar su comportamiento (setup) con el método when.
    @BeforeEach
    void setUp() {
        studentDTOUno = new StudentDTO();
        studentDTOUno.setId(1L);
        studentDTOUno.setStudentName("Uno");

        studentDTODos = new StudentDTO();
        studentDTODos.setId(2L);
        studentDTODos.setStudentName("Dos");

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 9.0));

        studentDTOUno.setSubjects(subjectDTOList);
    }

    @Test
    public void testReadUser() {
        when(studentService.read(1L)).thenReturn(studentDTOUno);
        
        StudentDTO studentDTO = studentService.read(1L);
        Assertions.assertEquals("Uno", studentDTO.getStudentName());
        Assertions.assertEquals(2, studentDTO.getSubjects().size());
    }

    @Test
    public void testGetAllUsers() {
        when(studentService.getAll()).thenReturn(Set.of(studentDTOUno, studentDTODos));

        Set<StudentDTO> studentDTOSet = studentService.getAll();
        Assertions.assertEquals(2, studentDTOSet.size());
    }

}
