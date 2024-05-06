package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.InitialDataTest;
import org.junit.jupiter.api.*;

import java.util.List;

public class StudentDAOTest {

    private IStudentDAO studentDAO;


    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    //Despues de que se ejecute cada test se vuelven a guardar los datos iniciales
    @AfterEach
    void tearDown() {
        InitialDataTest.resetFile();
    }

    @DisplayName("Crea un estudiante")
    @Test
    void createStudent() {
        //Arrange
        StudentDTO student = new StudentDTO(null, "Esteban Perez","",0.0,
                List.of(new SubjectDTO("Ingles",10.0)));

        //Act
        studentDAO.save(student);

        //Asssert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(student,studentDAO.findById(student.getId()));
    }


    @DisplayName("Editar los datos de un estudiante")
    @Test
    void editStudent() {
        //Arrange
        StudentDTO editedStudentDTO = studentDAO.findById(1L);
        editedStudentDTO.setStudentName("Juanito Perez");

        //Act
        studentDAO.save(editedStudentDTO);

        //Assert
        Assertions.assertTrue(studentDAO.exists(editedStudentDTO));
        Assertions.assertEquals(editedStudentDTO.getStudentName(),
                studentDAO.findById(1L).getStudentName());
    }

    @DisplayName("Buscar un estudiante por id")
    @Test
    void searchStudentById() {
        //Arrange -> Ya se tiene creado y preparado un estudinate con id 1

        //Act
        StudentDTO studentDTO = studentDAO.findById(1L);

        //Assert
        Assertions.assertNotNull(studentDTO);
    }

    @DisplayName("Buscar un estudiante que no existe por id")
    @Test
    void SearchStudentNotExistById() {
        //Arrange -> No existe un estudiante con id 100

        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(100L));

    }

    @DisplayName("Eliminar un estudiante")
    @Test
    void deleteStudent() {
        //Arrange
        StudentDTO studentDTO = studentDAO.findById(1L);

        //Act
        boolean response = studentDAO.delete(1L);

        //Assert
        Assertions.assertTrue(response);
        Assertions.assertFalse(studentDAO.exists(studentDTO));
    }

    @DisplayName("Eliminar un estudiante que no existe")
    @Test
    void deleteStudentNotExist() {
        //Arrange -> Se usa el id de un estudiante que no existe
        Long id= 100L;

        //Act
        //Assert
        Assertions.assertFalse(studentDAO.delete(id));
    }

}
