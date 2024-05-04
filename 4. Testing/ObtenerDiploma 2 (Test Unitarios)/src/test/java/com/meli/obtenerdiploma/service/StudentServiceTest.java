package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    private StudentDTO studentDTO;

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @BeforeEach
    public void setup() {
        this.studentDTO = new StudentDTO();
        studentDTO.setStudentName("Luis");
        studentDTO.setSubjects(List.of(new SubjectDTO("Fisica", 9.9)));

    }

    @Test
    @DisplayName("Se ha creado exitosamente un usuario")
    public void studentCreatedSuccessfully() {
        //act
        doNothing().when(studentDAO).save(studentDTO);

        studentService.create(studentDTO);

        //assert
        verify(studentDAO, times(1)).save(studentDTO);

    }

    @Test
    @DisplayName("Obtenemos la informacion de un usuario")
    public void obtenerUnUsuario(){
        //arrange
        Long id = 1L;
        studentDTO.setId(id);

        //act
        when(studentDAO.findById(id)).thenReturn(studentDTO);
        StudentDTO studentObtained = studentService.read(id);

        //assert
        Assertions.assertEquals(studentDTO, studentObtained);

    }

    @Test
    @DisplayName("Actualizacion del usuario exitosamente")
    public void updateAnUser() {

        //act

        doNothing().when(studentDAO).save(studentDTO);
        studentService.update(studentDTO);

        //assert
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Eliminacion de un usario de manera exitosa")
    public void deleteAnUser(){
        //arrange
        Long id = 1L;
        studentDTO.setId(id);

        //act
        when(studentDAO.delete(id)).thenReturn(true);
        studentService.delete(id);

        //assert
        verify(studentDAO, times(1)).delete(id);

    }


    @Test
    @DisplayName("Obtencion de todos los usuarios de forma exitosa")
    public void getAllUsers() {
        //arrange
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(9999L);
        stu.setStudentName("Luis");
        stu.setSubjects(subjects);

        Set<StudentDTO> studentDTOS = new HashSet<>();

        studentDTOS.add(stu);

        //act
        when(studentRepository.findAll()).thenReturn(studentDTOS);
        Set<StudentDTO> setStudentObtained = studentService.getAll();

        //assert

        Assertions.assertEquals(studentDTOS, setStudentObtained);
    }

}
