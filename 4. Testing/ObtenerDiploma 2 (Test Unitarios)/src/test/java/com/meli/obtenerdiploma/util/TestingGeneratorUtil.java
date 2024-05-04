package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;
import java.util.Set;

public class TestingGeneratorUtil {

    public static StudentDTO devolverUnSoloEstudianteConNombreYListaYID(){
        StudentDTO estudiante1 = new StudentDTO();
        estudiante1.setStudentName("Luis");
        estudiante1.setId(2L);
        estudiante1.setSubjects(List.of(new SubjectDTO("Mates", 10.0)));
        return estudiante1;
    }

    public static StudentDTO devolverUnSoloEstudianteConNombreYLista(){
        StudentDTO estudiante1 = new StudentDTO();
        estudiante1.setStudentName("Luis");
        estudiante1.setSubjects(List.of(new SubjectDTO("Mates", 10.0)));
        return estudiante1;
    }


    public static Set<StudentDTO> setDeEstudiantes() {
        StudentDTO estudiante1 = new StudentDTO();
        estudiante1.setStudentName("Luis");
        estudiante1.setSubjects(List.of(new SubjectDTO("Mates", 10.0)));

        StudentDTO estudiante2 = new StudentDTO();
        estudiante2.setStudentName("Fernanda");
        estudiante2.setSubjects(List.of(new SubjectDTO("Fisica", 9.0)));

        return Set.of(estudiante1, estudiante2);
    }

    public static Set<StudentDTO> setDeEstudiantesInJSON() {
        StudentDTO estudiante1 = new StudentDTO();
        estudiante1.setStudentName("Luis");
        estudiante1.setId(2L);
        estudiante1.setSubjects(List.of(new SubjectDTO("Mates", 10.0)));

        StudentDTO estudiante2 = new StudentDTO();
        estudiante2.setStudentName("Pedro");
        estudiante2.setId(1L);
        estudiante2.setSubjects(
                List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)));

        return Set.of(estudiante1, estudiante2);
    }
}
