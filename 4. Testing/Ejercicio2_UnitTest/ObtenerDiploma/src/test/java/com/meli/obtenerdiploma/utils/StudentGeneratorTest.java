package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentGeneratorTest {

    public static StudentDTO getStudentForTest() {
        return new StudentDTO(
                3L, "Cristopher", "Message", 5.5,
                List.of(new SubjectDTO("Matemáticas", 4.5),new SubjectDTO("Sociales", 6.5))
        );
    }

    public static Set<StudentDTO> getStudentsListForTest() {
        return new HashSet<>(List.of(
                new StudentDTO(3L, "Alex", "Message", 5.5,
                        List.of(new SubjectDTO("Matemáticas", 4.5), new SubjectDTO("Sociales", 6.5))),
                new StudentDTO(4L, "Brayan", "Message", 5.5,
                        List.of(new SubjectDTO("Matemáticas", 8.5), new SubjectDTO("Sociales", 9.5))),
                new StudentDTO(5L, "Sebas", "Message", 5.5,
                        List.of(new SubjectDTO("Matemáticas", 4.5), new SubjectDTO("Sociales", 6.5)))
        ));
    }



}
