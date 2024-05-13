package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoTest {
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Test 1 - Valida el registro de estudiante(StudentDTO) Cristian")
    void save() {
        //Arrange: define los requisitos de entrada y salida que debe de cumplir el codigo
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 9.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Cristian");
        studentDTO.setSubjects(subjectDTOList);

        //Act llamada del codigo que se quiere probar
        studentDAO.save(studentDTO);

        //Assert: comprobación de los resultados esperados
        Assertions.assertEquals(studentDTO, studentDAO.findById(studentDTO.getId()));
    }

    @Test
    @DisplayName("Test 2 - Valida la busqueda por ID 2 para un StudentDTO Pedro registrado")
    void findByIdTest(){
        //Arrange: define los datos de entrada y salida necesarios para la validacion
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setSubjects(subjectDTOList);
        //Act: llamado del codigo necesario para validación
        StudentDTO  studentDTO_2 =  studentDAO.findById(2L);

        //Assert: comprobación de los resultados esperados
        Assertions.assertEquals(studentDTO.toString(), studentDTO_2.toString());
    }

    @Test
    @DisplayName("Test 3 - Valida la busqueda por ID para un StudentDTO no registrado")
    void findByIdNoTest(){
        //Arrange: Definir los datos de entrada y de salida
        Long id = 0L;
        //Act y Assert
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> {studentDAO.findById(id);});
    }

    @Test
    @DisplayName("Test 4 - Modifica los datos de un StudentDTO registrado")
    void updateTest() {
        //Arrange: define los datos de entrada y salida necesarios para la validacion
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática", 10.0));
        subjectDTOList.add(new SubjectDTO("Física", 8.0));
        subjectDTOList.add(new SubjectDTO("Química", 4.0));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Criss");
        studentDTO.setSubjects(subjectDTOList);
        //Act: llamado del codigo necesario para validación
        studentDAO.save(studentDTO);
        //Assert: comprobación de los resultados esperados
        Assertions.assertEquals(studentDTO, studentDAO.findById(2L));
    }

    @Test
    @DisplayName("Test 5 - Eliminación de un StudentDTO existente")
    void deleteTest() {
        //Arrange: los datos de entrada necesarios para la eliminación
        Long id = 2L; //Id de un usuario existente
        Boolean result = true;
        //Act: Llamado del codigo necesario para la validacion
        Boolean ret = studentDAO.delete(id);
        //Assert comparación de los resultados deseados
        Assertions.assertEquals(result, ret);
    }

    @Test
    @DisplayName("Test 6 -Eliminación de un usuario no existente")
    void deleteNoTest() {
        //Arrange: preparación de los datos de entrada para filtrado de eliminación
        Long id = 0L;
        //Act y Assert
        Assertions.assertFalse(()->studentDAO.delete(id));
    }
}
