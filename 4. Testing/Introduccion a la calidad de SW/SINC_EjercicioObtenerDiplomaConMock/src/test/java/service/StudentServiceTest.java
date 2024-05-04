package service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;

    @Mock
    private IStudentDAO studentDAOMock;

    @InjectMocks
    private StudentService studentServiceUnderTest;

    @Test
    @DisplayName("Cuando se crea un Student se llama al metodo save")
    public void createStudentTest() {
        StudentDTO studentDTOInput = buildStudentDTO();
        studentServiceUnderTest.create(studentDTOInput);
        verify(studentDAOMock, times(1)).save(studentDTOInput);
    }

    @Test
    @DisplayName("Cuando se busca un Student por id trae el correcto")
    public void readStudentTest() {
        StudentDTO studentDTOInput = buildStudentDTO();
        when(studentDAOMock.findById(studentDTOInput.getId())).thenReturn(studentDTOInput);

        StudentDTO studentDTOOutput = studentServiceUnderTest.read(studentDTOInput.getId());
        Assertions.assertEquals(studentDTOInput, studentDTOOutput);
    }

    @Test
    @DisplayName("Cuando se actualiza un Studen se llama al metodo update")
    public void updateStudentTest(){
        StudentDTO studentDTOInput = buildStudentDTO();
        studentServiceUnderTest.update(studentDTOInput);
        verify(studentDAOMock, times(1)).save(studentDTOInput);
    }

    @Test
    @DisplayName("Cuando se borra un Student se llama al metodo delete")
    public void deleteStudentTest() {
        studentServiceUnderTest.delete(1L);
        verify(studentDAOMock).delete(1L);
    }

    @Test
    @DisplayName("Trae todos los Student")
    public void getAllTest() {
        Set<StudentDTO> studentDTOList = new HashSet<>();
        studentDTOList.add(buildStudentDTO());
        when(studentRepository.findAll()).thenReturn(studentDTOList);

        Set<StudentDTO> studentDTOSOutput = studentServiceUnderTest.getAll();

        Assertions.assertEquals(studentDTOList,studentDTOSOutput);
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
