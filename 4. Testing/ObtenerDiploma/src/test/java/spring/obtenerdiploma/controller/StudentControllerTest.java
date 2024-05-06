package spring.obtenerdiploma.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.obtenerdiploma.model.StudentDTO;
import spring.obtenerdiploma.service.IStudentService;
import utils.TestUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent() {
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTOWithTwoSubjects();
        //Act
        this.studentController.registerStudent(studentDTO);
        //Assert
        verify(studentService,atLeastOnce()).create(studentDTO);
    }

    @Test
    public void getStudent(){
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTOWithThreeSubjects();
        when(studentService.read(studentDTO.getId())).thenReturn(studentDTO);
        //Act
        StudentDTO studentDTO1 = this.studentController.getStudent(studentDTO.getId());
        //Assert
        verify(studentService,atLeastOnce()).read(studentDTO.getId());
        Assertions.assertEquals(studentDTO,studentDTO1);
    }
    @Test
    public void modifyStudent(){
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTOWithThreeSubjects();
        //Act
        this.studentController.modifyStudent(studentDTO);
        //Assert
        verify(studentService,atLeastOnce()).update(studentDTO);
    }
    @Test
    public void removeStudent(){
        //Arrange
        StudentDTO studentDTO = TestUtils.createStudentDTOWithTwoSubjects();
        //Act
        this.studentController.removeStudent(studentDTO.getId());
        //Assert
        verify(studentService,atLeastOnce()).delete(studentDTO.getId());
    }
      @Test
    public void listStudents(){
          //Arrange
          Set<StudentDTO> studentsDTO = new HashSet<>();
          studentsDTO.add(TestUtils.createStudentDTOWithTwoSubjects());
          studentsDTO.add(TestUtils.createStudentDTOWithThreeSubjects());
          when(studentService.getAll()).thenReturn(studentsDTO);
          //Act
          Set<StudentDTO> studentDTOSet = this.studentController.listStudents();
          //Assert
          Assertions.assertEquals(studentsDTO,studentDTOSet);
          verify(studentService,atLeastOnce()).getAll();
    }



}
