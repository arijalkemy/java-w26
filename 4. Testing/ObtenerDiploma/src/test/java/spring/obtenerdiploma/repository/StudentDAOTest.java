package spring.obtenerdiploma.repository;

import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.*;
import spring.obtenerdiploma.exceptions.StudentNotFoundException;
import spring.obtenerdiploma.model.StudentDTO;
import spring.obtenerdiploma.model.SubjectDTO;
import utils.TestUtils;

import java.util.List;

public class StudentDAOTest {
    IStudentDAO studentDAO;
    StudentDTO studentDTO;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestUtils.loadDataTestUsers();
        studentDAO = new StudentDAO();
        studentDTO = new StudentDTO();
    }

    @Test
    public void addAnExistingStudent() {
        //Arrange
        this.studentDTO = TestUtils.createStudentDTO(1L);

        //Act
        this.studentDAO.save(this.studentDTO);

        //Assert
        Assertions.assertEquals(1L, this.studentDTO.getId());
        Assertions.assertTrue(this.studentDAO.exists(this.studentDTO));
        Assertions.assertEquals(this.studentDAO.findById(this.studentDTO.getId()), this.studentDTO);

    }

    @Test
    public void addAnNonExistingStudent() {
        //Arrange
        this.studentDTO = TestUtils.createStudentDTOWithTwoSubjects();

        //Act
        this.studentDAO.save(this.studentDTO);

        //Assert
        Assertions.assertEquals(1L, this.studentDTO.getId());
        Assertions.assertTrue(this.studentDAO.exists(this.studentDTO));
        Assertions.assertEquals(this.studentDAO.findById(this.studentDTO.getId()), this.studentDTO);

    }

    @Test
    public void findStudentById() {
        //Arrange
        this.studentDTO = TestUtils.createStudentDTOWithTwoSubjects();
        this.studentDAO.save(this.studentDTO);

        //Act
        StudentDTO stu = this.studentDAO.findById(this.studentDTO.getId());

        //Assert
        Assertions.assertEquals(stu, this.studentDTO);

    }

    @Test
    public void modifyStudent() {
        //Arrange
        this.studentDTO = TestUtils.createStudentDTOWithTwoSubjects();

        this.studentDAO.save(this.studentDTO);

        //Act
        this.studentDTO.setStudentName("Pepe");
        this.studentDAO.save(this.studentDTO);

        //Assert
        Assertions.assertEquals(1L, this.studentDTO.getId());
        Assertions.assertTrue(this.studentDAO.exists(this.studentDTO));
        Assertions.assertEquals(this.studentDAO.findById(this.studentDTO.getId()), this.studentDTO);

    }

    @Test
    public void deleteStudent() {
        //Arrange
        this.studentDTO = TestUtils.createStudentDTOWithTwoSubjects();
        this.studentDAO.save(this.studentDTO);

        //Act
        this.studentDAO.delete(this.studentDTO.getId());
        //Assert
        Assertions.assertFalse(this.studentDAO.exists(this.studentDTO));
        Assertions.assertThrows(StudentNotFoundException.class, ()
                -> studentDAO.findById(this.studentDTO.getId()));

    }
}
