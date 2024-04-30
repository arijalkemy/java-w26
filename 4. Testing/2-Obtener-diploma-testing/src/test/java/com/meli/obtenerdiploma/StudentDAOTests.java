package com.meli.obtenerdiploma;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class StudentDAOTests {
    @Autowired
    IStudentDAO studentDAO;
    @Autowired
    IStudentRepository studentRepository;

    @Test()
    void shouldCreateStudentSuccesfully() {
        // Arrange

        List<SubjectDTO> subjects = List.of(new SubjectDTO("Materia", 7.5));
        StudentDTO studentToSave = new StudentDTO(
                null,
                "Nombre de estudiante",
                "Mensaje",
                Double.valueOf(7.5),
                subjects
        );

        // Act

        studentDAO.save(studentToSave);

        // Assert

        Assertions.assertTrue(studentDAO.exists(studentToSave));
    }

    @Test
    void shouldFindStudentSuccessfully() {
        // Arrange

        List<SubjectDTO> subjects = List.of(new SubjectDTO("Materia", 7.5));
        StudentDTO studentToSave = new StudentDTO(
                null,
                "Nombre de estudiante",
                "Mensaje",
                Double.valueOf(7.5),
                subjects
        );

        Long expectedId = Long.valueOf(studentRepository.findAll().size() + 1);

        // Act
        studentDAO.save(studentToSave);
        StudentDTO studentFound = studentDAO.findById(expectedId);

        // Assert
        Assertions.assertEquals(studentToSave, studentFound);
    }

    @Test
    void shouldModifyStudentSuccesfully() {
        // Arrange

        List<SubjectDTO> subjects = List.of(new SubjectDTO("Materia", 7.5));
        StudentDTO studentToModify = studentDAO.findById(Long.valueOf(studentRepository.findAll().size()));
        String oldName = studentToModify.getStudentName();

        // Act
        studentToModify.setStudentName(oldName + ' ' + "Diff");
        studentDAO.save(studentToModify);

        // Assert
        Assertions.assertNotEquals(oldName, studentToModify.getStudentName());
    }

    @Test
    void shouldRemoveStudentSuccessfully() {
        // Arrange

        Long studentToDeleteID = Long.valueOf(1);
        StudentDTO student = studentDAO.findById(studentToDeleteID);

        // Act

        studentDAO.delete(studentToDeleteID);

        // Assert

        Assertions.assertFalse(studentDAO.exists(student));
    }

    @Test
    void shouldListStudentsSuccesfully() {
        // Arrange
        Properties properties =  new Properties();
        String SCOPE = "";
        ObjectMapper objectMapper = new ObjectMapper();
        Set<StudentDTO> expectedStudents = new HashSet<>();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
            File file = ResourceUtils.getFile("src/" + SCOPE + "/resources/users.json");

            expectedStudents = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        Set<StudentDTO> studentDTOSet = studentRepository.findAll();

        // Assert
        assertThat(studentDTOSet, containsInAnyOrder(expectedStudents));
    }
}
