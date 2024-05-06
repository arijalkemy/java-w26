package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;

public class StudentUseTest {

    public static StudentDTO StudentAverageTen(){
        return new StudentDTO(3L,"Aaron Hotchner","",0.0,
                Arrays.asList(new SubjectDTO("Criminalística", 10.0),
                        new SubjectDTO("Psicología Forense", 10.0),
                        new SubjectDTO("Análisis Táctico", 10.0),
                        new SubjectDTO("Liderazgo de Equipo", 10.0)));
    }

    public static StudentDTO StudentAverageLessTen(){
        return new StudentDTO(1L, "Juan", "",0.0,
                Arrays.asList(new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química",6.0)));
    }

    public static StudentDTO StudentTest(){
        return new StudentDTO(4L,"Spencer Reid","",0.0,
                Arrays.asList(
                        new SubjectDTO("Psicología Forense", 10.0),
                        new SubjectDTO("Criminología", 10.0),
                        new SubjectDTO("Perfiles Criminales", 10.0),
                        new SubjectDTO("Entrevista e Interrogatorio", 10.0),
                        new SubjectDTO("Análisis del Comportamiento", 10.0),
                        new SubjectDTO("Psicopatología", 10.0),
                        new SubjectDTO("Investigación Criminal", 10.0),
                        new SubjectDTO("Ética y Legalidad", 10.0),
                        new SubjectDTO("Habilidades Blandas",5.0)
                ));
    }
}
