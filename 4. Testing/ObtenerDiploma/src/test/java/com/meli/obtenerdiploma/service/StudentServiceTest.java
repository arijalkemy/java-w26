package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @InjectMocks
    private StudentService service;

    @Mock
    private StudentDAO dao;

    @BeforeEach
    public void setUp() {
        StudentRepository repository = new StudentRepository();
        repository.setSCOPE("test");
        service.setStudentRepository(repository);
    }

    @Test
    public void findByIdStudentTest() {
        // Arrange
        StudentDTO expected = new StudentDTO(2L, "Pedro", null, null, List.of(
                new SubjectDTO("Matemática", 10D),
                new SubjectDTO("Física", 8D),
                new SubjectDTO("Química", 4D)
        ));

        when(dao.findById(expected.getId())).thenReturn(expected);

        // Act
        StudentDTO actual = service.read(expected.getId());

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findAllTest() {
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(
                new StudentDTO(1L, "Juan", null, null, List.of(
                        new SubjectDTO("Matemática", 9D),
                        new SubjectDTO("Física", 7D),
                        new SubjectDTO("Química", 6D)
                ))
        );
        expected.add(
                new StudentDTO(2L, "Pedro", null, null, List.of(
                        new SubjectDTO("Matemática", 10D),
                        new SubjectDTO("Física", 8D),
                        new SubjectDTO("Química", 4D)
                ))
        );

        Set<StudentDTO> actual = service.getAll();

        Assertions.assertEquals(expected.size(), actual.size());
    }
}
