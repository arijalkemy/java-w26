package com.meli.obtenerdiploma.unitarytest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    //mockear IStudentDAO
    @Mock
    private IStudentDAO studentDao;
    //mockear IStudentRepository
    @Mock
    private IStudentRepository studentRepository;

    //Inyectar en el servicio
    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        //Configurando el comportamiento del mock
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));
        //Configurando el comportamiento del mock
        doNothing().when(studentDao).save(studentDTO);
        //Ejecutando el método a probar
        studentService.create(studentDTO);
        //Verificando que el método save del mock haya sido llamado
        verify(studentDao, times(1)).save(studentDTO);

    }

    @Test
    public void testRead() {
        //Configurando el comportamiento del mock
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));
        //Configurando el comportamiento del mock
        when(studentDao.findById(123L)).thenReturn(studentDTO);
        //Ejecutando el método a probar
        StudentDTO result = studentService.read(123L);
        //Verificando que el método findById del mock haya sido llamado
        assertEquals(studentDTO, result);
    }

    @Test
    public void testUpdate() {
        //Configurando el comportamiento del mock
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));
        //Configurando el comportamiento del mock
        doNothing().when(studentDao).save(studentDTO);
        //Ejecutando el método a probar
        studentService.update(studentDTO);
        //Verificando que el método save del mock haya sido llamado
        verify(studentDao, times(1)).save(studentDTO);
    }
    @Test
    public void testDelete() {
        //Configurando el comportamiento del mock
        Long id = 123L;
        //Configurando el comportamiento del mock
        when(studentDao.delete(id)).thenReturn(true);
        //Ejecutando el método a probar
        studentService.delete(id);
        //Verificando que el método delete del mock haya sido llamado
        verify(studentDao, times(1)).delete(id);
    }

    @Test
    public void testGetAll() {
        //Configurando el comportamiento del mock
        StudentDTO studentDTO = new StudentDTO(123L, "Manuel", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));

        StudentDTO studentDTO2 = new StudentDTO(123L, "Pepe", "", 0.0, Arrays.asList(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 10.0),
                new SubjectDTO("Quimica", 10.0)
        ));
        Set<StudentDTO> students = Set.of(studentDTO, studentDTO2);

        //Configurando el comportamiento del mock
        when(studentRepository.findAll()).thenReturn(students);
        //Ejecutando el método a probar
        Set<StudentDTO> result = studentService.getAll();
        //Verificando que el método findAll del mock haya sido llamado
        assertEquals(students, result);
    }

}
