package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;

public class StudentGenerator {

    public static StudentDTO generateStudent(){
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Matemática",9D),
                new SubjectDTO("Física",7D),
                new SubjectDTO("Química",8D)
        );
        StudentDTO studentDTO = new StudentDTO(5L,
                "Juan",
                null,
                8D,
                subjectDTOList);

        return studentDTO;
    }

    public static StudentDTO generateStudentConHonores(){
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Matemática",10D),
                new SubjectDTO("Física",10D),
                new SubjectDTO("Química",10D)
        );
        StudentDTO studentDTO = new StudentDTO(5L,
                "Juan",
                null,
                10D,
                subjectDTOList);

        return studentDTO;
    }

    public static List<StudentDTO> generate3Students(){

        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Matemática",9D),
                new SubjectDTO("Física",7D),
                new SubjectDTO("Química",6D)
        );
        List<StudentDTO> students = List.of(
                new StudentDTO(1L,
                        "Juan",
                        null,
                        6.3,
                        subjectDTOList),
                new StudentDTO(2L,
                        "Diego",
                        null,
                        6.3,
                        subjectDTOList),
                new StudentDTO(3L,
                        "Pedro",
                        null,
                        6.3,
                        subjectDTOList)
        );

        return students;

    }
}
