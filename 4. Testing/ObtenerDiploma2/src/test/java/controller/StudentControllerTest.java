package controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    StudentDTO student = new StudentDTO(2L, "Cristina", "Felicitaciones", 50D,
            List.of(new SubjectDTO("Matematicas", 9.5D),
                    new SubjectDTO("biologia", 9.5D),
                    new SubjectDTO("politica", 9.5D)));


    @Test
    void shouldRegisterNewStudend(){
        ResponseEntity<?> responseEntity = studentController.registerStudent(student);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Mockito.verify(studentService).create(student);
    }

    @Test
    void shouldGetStudent(){
        when(studentService.read(2L)).thenReturn(student);
        StudentDTO studentDTO = studentController.getStudent(2L);

        Assertions.assertEquals(studentDTO.getStudentName(), "Cristina");
        Assertions.assertEquals(studentDTO.getAverageScore(), 50D);
    }

    @Test
    void shouldRemoveStudend(){
        ResponseEntity<?> responseEntity = studentController.removeStudent(2L);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Mockito.verify(studentService).delete(2L);
    }

    @Test
    void shouldModifyStudend(){
        ResponseEntity<?> responseEntity = studentController.modifyStudent(student);

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Mockito.verify(studentService).update(student);
    }
}
