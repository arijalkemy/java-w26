package com.meli.obtenerdiploma.util;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class InitialDataTest {

    private static final StudentDAO studentDAO = new StudentDAO();

    public static final Set<StudentDTO> STUDENTS = new LinkedHashSet<>(
            Set.of(new StudentDTO(1L, "Juan", "",0.0,
                            Arrays.asList(new SubjectDTO("Matemática",9.0),
                                    new SubjectDTO("Física",7.0),
                                    new SubjectDTO("Química",6.0))),
                    new StudentDTO(2L,"Pedro","",0.0,
                            Arrays.asList(new SubjectDTO("Matemática",9.0),
                                    new SubjectDTO("Física",7.0),
                                    new SubjectDTO("Química",6.0))),
                    new StudentDTO(3L,"Aaron Hotchner","",0.0,
                            Arrays.asList(new SubjectDTO("Criminalística", 10.0),
                                    new SubjectDTO("Psicología Forense", 10.0),
                                    new SubjectDTO("Análisis Táctico", 10.0),
                                    new SubjectDTO("Liderazgo de Equipo", 10.0))))
    );

    public static void resetFile(){
        studentDAO.saveAll(STUDENTS);
    }

    public static void blankFile(){
        studentDAO.saveAll(new HashSet<>());
    }


}
