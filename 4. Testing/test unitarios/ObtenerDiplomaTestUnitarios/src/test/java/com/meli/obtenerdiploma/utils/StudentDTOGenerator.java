package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;
import java.util.List;

public class StudentDTOGenerator {
    public static StudentDTO generateStudentDTO(Long id, String name, List<SubjectDTO> subjectsDTO) {
        return new StudentDTO(id, name, "", 0.0, subjectsDTO);
    }

    public static List<SubjectDTO> generateSubjectsDTOWithAverage(double score){
        return Arrays.asList(
                new SubjectDTO("Matemáticas", score),
                new SubjectDTO("Historia", score),
                new SubjectDTO("Ciencias", score)
        );
    }

}
