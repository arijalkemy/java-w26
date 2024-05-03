package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtils {

    public static StudentDTO createStudentDtoAverageOver9() {
        List<SubjectDTO> subjectDTOList = new ArrayList<SubjectDTO>();
        subjectDTOList.add(
                new SubjectDTO(
                        "Matemática",
                        9.0
                )
        );
        subjectDTOList.add(
                new SubjectDTO(
                        "Física",
                        10.0
                )
        );

        return new StudentDTO(
                4L,
                "Juan",
                null,
                7.33,
                subjectDTOList
        );
    }

    public static StudentDTO createStudentDto() {
        List<SubjectDTO> subjectDTOList = new ArrayList<SubjectDTO>();
        subjectDTOList.add(
                new SubjectDTO(
                        "Matemática",
                        8.0
                )
        );
        subjectDTOList.add(
                new SubjectDTO(
                        "Física",
                        8.0
                )
        );

        return new StudentDTO(
                4L,
                "Juan",
                null,
                7.33,
                subjectDTOList
        );
    }

    public static Set<StudentDTO> createStudentsSet() {
        Set<StudentDTO> studentDTOSet = new HashSet<StudentDTO>();
        List<SubjectDTO> subjectDTOList1 = new ArrayList<SubjectDTO>();
        subjectDTOList1.add(
                new SubjectDTO(
                        "Matemática",
                        10.0
                )
        );
        subjectDTOList1.add(
                new SubjectDTO(
                        "Física",
                        8.0
                )
        );
        subjectDTOList1.add(
                new SubjectDTO(
                        "Química",
                        4.0
                )
        );

        studentDTOSet.add(
            new StudentDTO(
                    2L,
                    "Pedro",
                    null,
                    null,
                    subjectDTOList1
            )
        );

        List<SubjectDTO> subjectDTOList2 = new ArrayList<SubjectDTO>();
        subjectDTOList2.add(
                new SubjectDTO(
                        "Matemática",
                        9.0
                )
        );
        subjectDTOList2.add(
                new SubjectDTO(
                        "Física",
                        7.0
                )
        );

        studentDTOSet.add(
                new StudentDTO(
                        1L,
                        "Carlos",
                        "Mensaje",
                        9.7,
                        subjectDTOList2
                )
        );

        return studentDTOSet;
    }
}
