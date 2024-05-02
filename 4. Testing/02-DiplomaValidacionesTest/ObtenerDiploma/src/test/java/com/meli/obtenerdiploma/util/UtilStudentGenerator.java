package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UtilStudentGenerator {

    public static StudentDTO studentWithAbove9Average(String name, Long studentId){
        StudentDTO responseStudent = new StudentDTO();
        responseStudent.setStudentName(name);
        responseStudent.setId(studentId);
        responseStudent.setAverageScore(9.9);
        responseStudent.setSubjects(Arrays.asList(
                new SubjectDTO("Matematica", 9.9),
                new SubjectDTO("Fisica", 9.9),
                new SubjectDTO("Quimica", 9.9)));

        return responseStudent;
    }

    public static StudentDTO studentWithBelow9Average(String name, Long studentId){
        StudentDTO responseStudent = new StudentDTO();
        responseStudent.setStudentName(name);
        responseStudent.setId(studentId);
        responseStudent.setAverageScore(7.0);
        responseStudent.setSubjects(Arrays.asList(
                new SubjectDTO("Matematica", 7.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 7.0)));

        return responseStudent;
    }

    public static StudentDTO studentWithoutId(String name){
        StudentDTO responseStudent = new StudentDTO();
        responseStudent.setStudentName(name);
        responseStudent.setAverageScore(7.0);
        responseStudent.setSubjects(Arrays.asList(
                new SubjectDTO("Matematica", 7.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 7.0)));

        return responseStudent;
    }

    public static Set<StudentDTO> studentSet(){
        StudentDTO responseStudent = new StudentDTO();
        responseStudent.setStudentName("Jose Mourinho");
        responseStudent.setId(1L);
        responseStudent.setAverageScore(7.0);
        responseStudent.setSubjects(Arrays.asList(
                new SubjectDTO("Matematica", 7.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 7.0)));

        StudentDTO responseStudent2 = new StudentDTO();
        responseStudent2.setStudentName("Pep Guardiola");
        responseStudent2.setId(2L);
        responseStudent2.setAverageScore(9.0);
        responseStudent2.setSubjects(Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 9.0),
                new SubjectDTO("Quimica", 9.0)));

        StudentDTO responseStudent3 = new StudentDTO();
        responseStudent3.setStudentName("Carlo Ancelotti");
        responseStudent3.setId(3L);
        responseStudent3.setAverageScore(6.0);
        responseStudent3.setSubjects(Arrays.asList(
                new SubjectDTO("Matematica", 6.0),
                new SubjectDTO("Fisica", 6.0),
                new SubjectDTO("Quimica", 6.0)));

        Set<StudentDTO> setResponse = new HashSet<>();
        setResponse.addAll(Arrays.asList(responseStudent, responseStudent2, responseStudent3));

        return setResponse;
    }
}
