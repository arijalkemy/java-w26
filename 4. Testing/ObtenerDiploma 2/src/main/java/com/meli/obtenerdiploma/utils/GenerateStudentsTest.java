package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateStudentsTest {
    public static StudentDTO generateStudent() {
        return new StudentDTO(1L,"Juan", "Perez", 10.0 , generateSubjects());
    }

    public static Set<StudentDTO> generateStudents() {
        List<SubjectDTO> subjects = generateSubjects();
        Set<StudentDTO> students = new HashSet<>();

        students.add(new StudentDTO(1L,"Juan", "Perez", 10.0, subjects));
        students.add(new StudentDTO(2L,"Maria", "Gomez", 9.0, subjects));
        students.add(new StudentDTO(3L,"Pedro", "Lopez", 8.0, subjects));

        return students;
    }

    private static List<SubjectDTO> generateSubjects() {
        return new ArrayList<>(){
            {
                add(new SubjectDTO("Matematicas", 10.0));
                add(new SubjectDTO("Física", 10.0));
                add(new SubjectDTO("Logica", 8.0));
            }
        };
    }
}
