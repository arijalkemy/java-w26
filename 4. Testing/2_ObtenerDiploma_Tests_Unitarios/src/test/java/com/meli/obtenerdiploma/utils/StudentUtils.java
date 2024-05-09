package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentUtils {

    public static StudentDTO createCommonStudent(Long studentId) {

        return new StudentDTO(
            studentId, "Giuliano", null, null,
            List.of(
                new SubjectDTO("Matemáticas", 4.5),
                new SubjectDTO("Sociales", 6.5)
            )
        );
    }

    public static StudentDTO createOutstandingStudent(Long studentId) {

        return new StudentDTO(
            studentId, "Cristopher", null, null,
            List.of(
                new SubjectDTO("Matemáticas", 9.0),
                new SubjectDTO("Sociales", 10.0)
            )
        );
    }

    /**
     * @return Un {@link Set} mutable con los {@link StudentDTO} para tests.
     */
    public static Set<StudentDTO> createTestStudents() {

        Set<StudentDTO> testStudents = new HashSet<>();

        testStudents.add(StudentDTO.builder()
            .id(1L)
            .subjects(List.of(
                new SubjectDTO("Ingles", 4.0),
                new SubjectDTO("Lengua", 0.0)
            ))
            .build());
        testStudents.add(StudentDTO.builder()
            .id(2L)
            .subjects(List.of(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Arte", 9.6)
            ))
            .build());

        return testStudents;
    }
}
