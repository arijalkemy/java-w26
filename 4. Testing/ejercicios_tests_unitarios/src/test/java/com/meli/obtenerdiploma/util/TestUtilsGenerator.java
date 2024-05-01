package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class TestUtilsGenerator {
    public static Set<StudentDTO> getStudentsSet() {
        return new HashSet<>(){{
            add(new StudentDTO(
               1L,
                "Agustin Tapia",
                "El alumno Agustin Tapia ha obtenido un promedio de 9,5. Felicitaciones!",
                9.5,
                List.of(
                    new SubjectDTO(
                        "Matemática",
                        9.0
                    ),
                    new SubjectDTO(
                        "Química",
                        10.0
                    )
                )
            ));
        }};
    }

    public static StudentDTO getStudent() {
        StudentDTO student = new StudentDTO();

        student.setId(1L);
        student.setStudentName("Agustin Tapia");
        student.setSubjects(List.of(
            new SubjectDTO(
                "Matemática",
                9.0
            ),
            new SubjectDTO(
                "Química",
                10.0
            )
        ));

        return student;
    }

    public static StudentDTO getNewStudent() {
        StudentDTO student = new StudentDTO();

        student.setStudentName("Agustin Tapia");
        student.setSubjects(List.of(
            new SubjectDTO(
                "Matemática",
                9.0
            ),
            new SubjectDTO(
                "Química",
                10.0
            )
        ));

        return student;
    }

    public static StudentDTO getStudentWithMessageAndAverageScore() {
        return new StudentDTO(
            1L,
            "Agustin Tapia",
            "El alumno Agustin Tapia ha obtenido un promedio de 9,5. Felicitaciones!",
            9.5,
            List.of(
                new SubjectDTO(
                    "Matemática",
                    9.0
                ),
                new SubjectDTO(
                    "Química",
                    10.0
                )
            )
        );
    }
}
