package com.meli.obtenerdiploma.units.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.*;

public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        TestUtils.deleteInfoRepository();
        studentDAO = new StudentDAO();
    }

    @AfterAll
    static void tearDown() {
        TestUtils.deleteInfoRepository();
    }

    @Test
    @DisplayName("Guarda un estudiante")
    public void guardarEstudianteTest() {
        StudentDTO studentDTOaGuardar = TestUtils.createStudentDTO();
        studentDAO.save(studentDTOaGuardar);
        StudentDTO studentDTOaEncontrado = studentDAO.findById(studentDTOaGuardar.getId());
        Assertions.assertEquals(studentDTOaGuardar, studentDTOaEncontrado);
    }

    @Test
    @DisplayName("Elimina un estudiante por id")
    public void eliminarEstudiantePorIdTest() {
        //Arrange
        Long id = 1L;
        StudentDTO studentDTOaBorrar = TestUtils.createStudentDTO();

        //Act and Assert
        //Guardar el estudiante para después borrarlo
        studentDAO.save(studentDTOaBorrar);
        //Se borra el estudiante que se creo
        studentDAO.delete(id);
        //Si el delete salió bien quiere decir que ese estudiante ya no se encuentra persistido y arroja la excepción
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentDTOaBorrar.getId()));
    }

    @Test
    @DisplayName("Verifica que el estudiante exista, debería dar true")
    public void verificarExisteEstudianteTrueTest() {
        //Arrange
        Boolean expected = Boolean.TRUE;
        StudentDTO studentDTOaBuscarExistencia = TestUtils.createStudentDTO();

        //Act
        //Guardar el estudiante
        studentDAO.save(studentDTOaBuscarExistencia);
        //Verificamos que el estudiante exista
        Boolean output = studentDAO.exists(studentDTOaBuscarExistencia);

        //Assert
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Verifica que el estudiante no exista, debería dar false")
    public void verificarExisteEstudianteFalseTest() {
        //Arrange
        Boolean expected = Boolean.FALSE;
        StudentDTO studentDTOaBuscarExistencia = TestUtils.createStudentDTO();

        //Act
        //Verificamos que el estudiante exista
        Boolean output = studentDAO.exists(studentDTOaBuscarExistencia);

        //Assert
        //Si todo salió bien debería ser falso
        Assertions.assertEquals(expected, output);
    }

    @Test
    @DisplayName("Busca un estudiante por el id y devuelve el estudiante encontrado")
    public void buscarUnEstudiantePorIdCaminoFelizTest() {
        //Arrange
        StudentDTO studentDTOaBuscar = TestUtils.createStudentDTO();

        //Act
        //Guardar el estudiante
        studentDAO.save(studentDTOaBuscar);
        //Verificamos que el estudiante exista por id
        StudentDTO output = studentDAO.findById(studentDTOaBuscar.getId());
        //Assert
        Assertions.assertEquals(studentDTOaBuscar, output);
    }

    @Test
    @DisplayName("Busca un estudiante por Id pero este id no existe, debería devolver" +
            " un StudentNotFoundException")
    public void buscarUnEstudiantePorIdCaminoTristeTest() {
        //Arrange
        Long id = 1L;

        //Act and Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

}
