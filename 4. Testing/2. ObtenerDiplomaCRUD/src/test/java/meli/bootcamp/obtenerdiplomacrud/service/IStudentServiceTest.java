package meli.bootcamp.obtenerdiplomacrud.service;

import meli.bootcamp.obtenerdiplomacrud.model.StudentDTO;
import meli.bootcamp.obtenerdiplomacrud.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IStudentServiceTest {

    @Mock
    StudentService studentService;

    @Test
    @DisplayName("Create student with invalid name")
    void createInvalidName() {
        StudentDTO studentDTO = new StudentDTO(1L, "raul", null, 10.0, List.of(
                new SubjectDTO("matematica", 10.0)));

        assertThrows(MethodArgumentNotValidException.class, () -> studentService.create(studentDTO));
    }
}