package com.meli.obtenerdiploma.util;

import java.util.List;
import java.util.Set;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

public class StudentBuilder {

    public static Set<StudentDTO> studentsFromJSON()
    {
        List<SubjectDTO> list1 = 
            List.of(
                new SubjectDTO("Matemática", 9.0), 
                new SubjectDTO("Física", 7.0), 
                new SubjectDTO("Química", 6.0));

        List<SubjectDTO> list2 = 
            List.of(
                new SubjectDTO("Matemática", 10.0), 
                new SubjectDTO("Física", 8.0), 
                new SubjectDTO("Química", 4.0));

        StudentDTO studen1 = new StudentDTO(1L, "Juan", null, null, list1);
        StudentDTO studen2 = new StudentDTO(2L, "Pedro", null, null, list2);

        return Set.of(studen2, studen1);
    }

    public static StudentDTO getStudentTest() {

        List<SubjectDTO> list1 = 
            List.of(
                new SubjectDTO("Matemática", 9.0), 
                new SubjectDTO("Física", 7.0), 
                new SubjectDTO("Química", 6.0));

        StudentDTO studen1 = new StudentDTO(1L, "Juan", null, null, list1);
        return studen1;
    }

    public static StudentDTO getStudentDTOGoodAverage()
    {
        List<SubjectDTO> list1 = 
            List.of(
                new SubjectDTO("Matemática", 9.0), 
                new SubjectDTO("Física", 9.0), 
                new SubjectDTO("Química", 10.0));

        StudentDTO studen1 = new StudentDTO(1L, "Antonio", null, null, list1);
        return studen1;

    }
}
