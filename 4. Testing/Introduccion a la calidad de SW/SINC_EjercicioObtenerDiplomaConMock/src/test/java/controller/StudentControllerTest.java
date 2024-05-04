package controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentServiceMock;

    @InjectMocks
    private StudentController studentControllerUnderTest;

    @Test
    @DisplayName("Cuando se registra un Student se llama al metodo create del servicio")
    public void registerStudentTest() {
        StudentDTO studentDTOInput = buildStudentDTO();

        studentControllerUnderTest.registerStudent(studentDTOInput);

        verify(studentServiceMock, atLeastOnce()).create(studentDTOInput);
    }

    @Test
    @DisplayName("Cuando se consulta un Student por id se llama al metodo read del servicio")
    public void getStudentTest() {
        Long idStudent = 1L;

        studentControllerUnderTest.getStudent(idStudent);

        verify(studentServiceMock, atLeastOnce()).read(idStudent);
    }

    @Test
    @DisplayName("Cuando se actualiza un Student se llama al metodo update del servicio")
    public void modifyStudentTest() {
        StudentDTO studentDTOInput = buildStudentDTO();

        studentControllerUnderTest.modifyStudent(studentDTOInput);

        verify(studentServiceMock, atLeastOnce()).update(studentDTOInput);
    }

    @Test
    @DisplayName("Cuando borro un Student por Id se llama al metodo delete del servicio")
    public void removeStudentTest() {
        Long idStudent = 1L;

        studentControllerUnderTest.removeStudent(idStudent);

        verify(studentServiceMock, atLeastOnce()).delete(idStudent);
    }

    @Test
    @DisplayName("Cuando quiero una lista de Students llama al metodo getAll del servicio")
    public void listStudentsTest() {
        studentControllerUnderTest.listStudents();

        verify(studentServiceMock, atLeastOnce()).getAll();
    }


    //Metodo para crear un StudentDTO
    private StudentDTO buildStudentDTO() {
        SubjectDTO subjectDTO1 = new SubjectDTO("Matematica", 8d);
        SubjectDTO subjectDTO2 = new SubjectDTO("Fisica", 10d);
        StudentDTO student = new StudentDTO(1l, "Marcos", "", 9.00,
                new ArrayList<>(List.of(subjectDTO1, subjectDTO2)));
        return student;
    }
}
