package com.meli.obtenerdiploma.unit.repository;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.RepositoryLoader;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.JSONSourcer;
import com.meli.obtenerdiploma.util.StudentBuilder;

public class StudentDAOTest {

    private StudentDAO studentDAOToTest;

    @BeforeEach
    public void beforeEachTest() throws FileNotFoundException {

        //Esta solución podria ser costosa
        JSONSourcer.copySnapShoot(ResourceUtils.CLASSPATH_URL_PREFIX+"users.json");

        this.studentDAOToTest = new StudentDAO(); 

        
    }

    @AfterEach
    public void AfterEachTest()
    {
        JSONSourcer.redoSnapShoot();
    }

    @Test
    @DisplayName("Test to save a StudentDTO does not exist")
    public void saveStudentTest() {

        //Arrage
        StudentDTO studentToSave = new StudentDTO(Long.MAX_VALUE, "Test", "Test", null, null);
        int countStudentsBeforeSave = studentDAOToTest.countStudents();

        //Act
        studentDAOToTest.save(studentToSave); 

        //Asserts
        Assertions.assertEquals(countStudentsBeforeSave + 1, studentDAOToTest.countStudents());
        Assertions.assertEquals(countStudentsBeforeSave + 1 ,studentToSave.getId());

    }

    @Test
    @DisplayName("Test to save a Student which exists")
    public void saveStudentExistsTest()
    {
        //Arrange

        StudentDTO studentExists = new StudentDTO(1L, null, null, null, null);
        int countStudentsBeforeSave = studentDAOToTest.countStudents();


        //Act
        studentDAOToTest.save(studentExists);

        //Assertions
        Assertions.assertEquals(countStudentsBeforeSave, studentDAOToTest.countStudents());

        /*
         * Nota: Teoricamente no se hacen pruebas cuando se sabe que esa parte del código es tan sencillo que "NO VA A FALLAR" <<¿Danger?>>.
         * En este caso como los usuarios antes y depues deberian ser los mismos
         * 
         * Justamente aquí pienso que el hecho de que sea complicado de testear es un indicio de que algo anda mal (Probablemente en diseño).
         */
    }

    @Test
    @DisplayName("Test delte student")
    public void deleteStudentTest() {

        //Arrage
        Long idStudentToDelete = 1L; //Siguiendo el .json si debe existir
        boolean expected = true;
        int usersBeforeDelete = this.studentDAOToTest.countStudents();
        //Act
        boolean result = this.studentDAOToTest.delete(idStudentToDelete); 

        //Assertion
        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(usersBeforeDelete - 1, this.studentDAOToTest.countStudents());
    }

    @Test
    public void deleteNullStudentTest() {

        //Arrage
        Long idStudentToDelete = null; //Siguiendo el .json si debe existir
        boolean expected = false;
        //Act
        boolean result = this.studentDAOToTest.delete(idStudentToDelete); 

        //Asserts
        Assertions.assertEquals(expected, result);
    }


    @Test
    @DisplayName("Test if student by id is found")
    public void findByIdStudentTest() {
        

        //Arrange
        Long idToFind2 = 1L;
        StudentDTO expected = StudentBuilder.getStudentTest(); 
        
        /**
         * Nota: Este metodo antes se probaba revisando el array (lista xd) de StudentBuilder, 
         * pero debido a que su carga es por hilos, puede variar el orden de insercion y por 
         * tanto el primero no siempre es Pedro por ejemplo
         */        


        //Act
        StudentDTO studentDTO = this.studentDAOToTest.findById(idToFind2);

        //Assertions
        Assertions.assertEquals(expected, studentDTO);
    
        /*
         * Nota: En este caso en este test unitario se reviso el metodo para dos casos en el que existe y en el que no
         */

        /**
         * Nota: Llegue a contemplar un caso con ID null, pero no tiene sentido partiendo de que el sistema asigna los IDs, y 
         * lo mismo si fuera una DB. Además que ya hay un test que valida la creación de un estudiante.
        */
    }


    @Test
    @DisplayName("Test if student by id is not found")
    public void findByIdBadStudentTest() {
        //Arrange
        Long idToFind = -999L;

        //Assertions and act
        Assertions.assertThrows(StudentNotFoundException.class, ()->{
            this.studentDAOToTest.findById(idToFind);
        });
        
    }


    
    @Test
    public void existsStudentTest() {
        //Arrange
        StudentDTO studenToValidate1 = new StudentDTO(2L, null, null, null, null);
        StudentDTO studenToValidate2 = new StudentDTO(null, null, null, null, null);
        StudentDTO studenToValidate3 = new StudentDTO(999L, null, null, null, null);
        //Act
        boolean result1 = this.studentDAOToTest.exists(studenToValidate1);
        boolean result2 = this.studentDAOToTest.exists(studenToValidate2);
        boolean result3 = this.studentDAOToTest.exists(studenToValidate3);
        
        //Assertions
        Assertions.assertTrue(result1);
        Assertions.assertFalse(result2);
        Assertions.assertFalse(result3);
    }

    //Nota final: La clase StudentDAO para muy acoplado solo por el hecho de llamar operaciones de save, delete, findbyid internamente y tener 2 fuentes de datos (Set y el JSON)
}
