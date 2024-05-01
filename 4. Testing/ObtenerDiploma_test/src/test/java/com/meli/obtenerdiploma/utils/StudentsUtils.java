package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentsUtils {
    public static Set<StudentDTO> getMockStudents() {
        return new HashSet<>(
                List.of(
                        new StudentDTO(1L, "Juan Manuel", null, null, new ArrayList<>(
                                List.of(
                                        new SubjectDTO("Matemática", 9.0),
                                        new SubjectDTO("Física", 7.0),
                                        new SubjectDTO("Química", 6.0)
                                )
                        )),
                        new StudentDTO(2L, "Pedro", null, null, new ArrayList<>(
                                List.of(
                                        new SubjectDTO("Matemática", 10.0),
                                        new SubjectDTO("Física", 8.0),
                                        new SubjectDTO("Química", 4.0)
                                )
                        )),
                        new StudentDTO(3L, "Mariano", null, null, new ArrayList<>(
                                List.of(
                                        new SubjectDTO("Matemática", 9.0),
                                        new SubjectDTO("Física", 7.0),
                                        new SubjectDTO("Química", 6.0)
                                )
                        ))
                )
        );
    }
}
