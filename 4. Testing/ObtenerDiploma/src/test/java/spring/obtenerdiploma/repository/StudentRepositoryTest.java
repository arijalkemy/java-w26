package spring.obtenerdiploma.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import spring.obtenerdiploma.model.StudentDTO;
import spring.obtenerdiploma.model.SubjectDTO;
import utils.TestUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Properties;

public class StudentRepositoryTest {
    IStudentRepository studentRepository;
    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestUtils.loadDataTestUsers();
        studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }

    @Test
    public void listAllStudents() {
        //Arrange
        Set<StudentDTO> studentsDTO = new HashSet<>();
        studentsDTO.add(TestUtils.createStudentDTOWithTwoSubjects()
        );

        studentsDTO.add(
                TestUtils.createStudentDTOWithThreeSubjects()
        );

        studentsDTO.forEach((studentDTO) -> {
            this.studentDAO.save(studentDTO);
        });
        //Act
        Set<StudentDTO> students = this.studentRepository.findAll();

        //Assert
        Assertions.assertEquals(studentsDTO.size(), students.size());
        Assertions.assertTrue(students.containsAll(studentsDTO));
    }


}
