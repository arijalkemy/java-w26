package com.meli.obtenerdiploma.utils;

import java.text.DecimalFormat;
import java.util.List;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

public class StudentDtoBuilder {

    public static StudentDTO buildBasicStudentDTO(Long id) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(
                List.of(
                        new SubjectDTO("Matematicas", 8.0),
                        new SubjectDTO("Fisica", 8.0)));
        return studentDTO;
    }

    public static void setExtraAttributesStudentDto(StudentDTO studentDTO) {

        studentDTO.setAverageScore(8.0);
        studentDTO
                .setMessage("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "
                        + new DecimalFormat("#.##").format(studentDTO.getAverageScore()) + ". Puedes mejorar.");
    }
}
