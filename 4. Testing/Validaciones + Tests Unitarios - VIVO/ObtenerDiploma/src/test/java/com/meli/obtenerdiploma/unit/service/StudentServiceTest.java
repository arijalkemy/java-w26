package com.meli.obtenerdiploma.unit.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.StudentBuilder;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {


    @Mock //No usa el context de Spring en comparación con MockBean
    private IStudentRepository studentRepositoryMock;
    
    @Mock
    private IStudentDAO studentDAOMock;

    @InjectMocks
    private StudentService systemUnterTest;

    @Test
    @DisplayName("Test if Data Acccess Object is called")
    public void createStudentTest(){
        
        //Act
        systemUnterTest.create(null);

        //Assertions
        verify(studentDAOMock, times(1)).save(null);
    }

    @Test
    @DisplayName("Test if Data Acccess Object is called")
    public void updateStudentTest()
    {
        //Act
        systemUnterTest.update(null);
        //Assertions
        verify(studentDAOMock, times(1)).save(null);
    }

    @Test
    @DisplayName("Test if Data Acccess Object is called")
    public void deleteStudentTest()
    {
        //Act
        systemUnterTest.delete(null);

        //Assertions
        verify(studentDAOMock, times(1)).delete(null);
    }

    /*
     * Nota: Sin duda alguna estos tests no sirve para nada. Pues como se dispone el servicio
     * tan solo se esta delegando la llamada a un ente externo, y como se solicita mock para
     * el repositorio y el DAO. Nada que hacer.
     */

     @Test
     @DisplayName("Test if the get student by id")
     public void getStudentTest()
     {
        //Arrange
        Long idStudent = 1L;
        StudentDTO studentExpected = StudentBuilder.getStudentTest();

        //Act
        when(studentDAOMock.findById(idStudent)).thenReturn(studentExpected);
        StudentDTO result = systemUnterTest.read(idStudent);

        //Assertions
        Assertions.assertEquals(studentExpected, result);
     }


     @Test
     @DisplayName("Test if the getAll only call method by Service")
     public void getAllStudentTest()
     {

        //Act
        when(studentRepositoryMock.findAll()).thenReturn(StudentBuilder.studentsFromJSON());
        Set<StudentDTO> result = systemUnterTest.getAll();

        //Assertions
        Assertions.assertEquals(StudentBuilder.studentsFromJSON(), result);
        verify(studentRepositoryMock, times(1)).findAll();
     }

}
