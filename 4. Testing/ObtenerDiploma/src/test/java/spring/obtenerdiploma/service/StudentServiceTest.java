package spring.obtenerdiploma.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.obtenerdiploma.model.StudentDTO;
import spring.obtenerdiploma.repository.IStudentDAO;
import spring.obtenerdiploma.repository.IStudentRepository;
import spring.obtenerdiploma.repository.StudentDAO;
import utils.TestUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudent() {
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTOWithTwoSubjects();

        //Act
        this.studentService.create(studentDTO);

        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);

    }

    @Test
    public void readStudent() {
        //Arrange
        StudentDTO studentDTO =TestUtils.createStudentDTOWithThreeSubjects();

        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        //Act
        StudentDTO studentDTO1 = this.studentService.read(studentDTO.getId());

        Assertions.assertEquals(studentDTO, studentDTO1);
        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
    }

    @Test
    public void updateStudent() {
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTOWithTwoSubjects();

        //Act
        this.studentService.update(studentDTO);

        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);

    }

    @Test
    public void deleteStudent() {
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTOWithThreeSubjects();

        //Act
        this.studentService.delete(studentDTO.getId());

        //Assert
        verify(studentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    public void getAllStudents() {
        //Arrange
        Set<StudentDTO> studentsDTO = new HashSet<>();
        studentsDTO.add(TestUtils.createStudentDTOWithTwoSubjects());

        studentsDTO.add(TestUtils.createStudentDTOWithThreeSubjects());

        when(studentRepository.findAll()).thenReturn(studentsDTO);
        //Act
        Set<StudentDTO> students = this.studentService.getAll();

        //Assert
        verify(studentRepository,atLeastOnce()).findAll();
        Assertions.assertTrue(students.containsAll(studentsDTO));

    }
}
