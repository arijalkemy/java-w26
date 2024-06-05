package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Con base en un id se debe obtiener un StudentDTO registrado")
    public void readTest(){
        //Arrange: definición de los datos de entrada y de salida
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO_esperado = new StudentDTO();
        studentDTO_esperado.setId(2L);
        studentDTO_esperado.setStudentName("Pedro");
        studentDTO_esperado.setSubjects(subjectDTOList);

        //Act: llamado del codigo que se quiere probar
        Mockito.when(studentDAO.findById(2L)).thenReturn(studentDTO_esperado);
        StudentDTO studentDTO_obtenido =  studentService.read(2L);

        //Assert: Comprobacion de los resultados
        Assertions.assertEquals(studentDTO_esperado, studentDTO_obtenido);
    }

    @Test
    @DisplayName("Con base en un id se debe obtiener un excepcion ya que no existe el registro")
    public void readTestSadPath(){
        //Arrange: Definir los datos de entrada y de salida esperados
        Long id = 0L;
        //Act y Assert
        Mockito.when(studentDAO.findById(id)).thenThrow(StudentNotFoundException.class);
        Assertions.assertThrows(StudentNotFoundException.class, ()->{studentService.read(0L);});
    }

    @Test
    @DisplayName("Test obtención de todos los StudentDTO")
    public void getAllTest(){
        //Arrange: Definir los datos de entrada y de salida
        //Arrange: definición de los datos de entrada y de salida
        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setSubjects(subjectDTOList);

        List<SubjectDTO> subjectDTOList_1 = new ArrayList<>();
        subjectDTOList_1.add(new SubjectDTO("Matemática", 9.0));
        subjectDTOList_1.add(new SubjectDTO("Física", 7.0));
        subjectDTOList_1.add(new SubjectDTO("Química", 6.0));
        StudentDTO studentDTO_1 = new StudentDTO();
        studentDTO_1.setId(1L);
        studentDTO_1.setStudentName("Juan");
        studentDTO_1.setSubjects(subjectDTOList_1);

        Set<StudentDTO> datosEsperados = new HashSet<>();
        datosEsperados.add(studentDTO);
        datosEsperados.add(studentDTO_1);

        //Act: ejecutar sección de codigo a testear
        Mockito.when(studentRepository.findAll()).thenReturn(datosEsperados);
        Set<StudentDTO> datosObtenidos = studentService.getAll();

        //Assert: Comprobación de los datos esperados y obtenidos
        Assertions.assertEquals(datosEsperados, datosObtenidos);
    }

    @Test
    @DisplayName("Test, escenario donde no hay registros de StudentDTO")
    public void getAllTestListaVacia(){
        //Act: llamada del codigo a testear y mockear
        Mockito.when(studentRepository.findAll()).thenReturn(null);
        Set<StudentDTO> datosObtenidos = studentService.getAll();
        //Assert: comprobación de los resultados
        Assertions.assertNull(datosObtenidos);
    }







}
