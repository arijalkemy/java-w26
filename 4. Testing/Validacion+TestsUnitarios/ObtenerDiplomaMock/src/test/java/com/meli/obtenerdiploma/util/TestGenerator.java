package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestGenerator {
     Set<StudentDTO> studentDTOList = new HashSet<>();

    public TestGenerator(){
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(1L);
        stu.setStudentName("Facundo");
        stu.setSubjects(subjects);
        studentDTOList.add(stu);

        StudentDTO stu2 = new StudentDTO();
        stu2.setId(2L);
        stu2.setStudentName("Juan");
        stu2.setSubjects(subjects);
        studentDTOList.add(stu2);
    }

    public StudentDTO findById(Long id){
        return studentDTOList.stream().filter(x-> x.getId().equals(id)).findFirst()
                .orElseThrow(() ->new StudentNotFoundException(id));

    }

    public Set<StudentDTO> findAll(){
        return studentDTOList;
    }

    private void generateStudents(){
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(1L);
        stu.setStudentName("Facundo");
        stu.setSubjects(subjects);
        studentDTOList.add(stu);
        StudentDTO stu2 = new StudentDTO();
        stu.setId(2L);
        stu.setStudentName("Juan");
        stu.setSubjects(subjects);
        studentDTOList.add(stu2);
    }

    public StudentDTO getStudentDTO(){
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(1L);
        stu.setStudentName("Facundo");
        stu.setSubjects(subjects);
        return stu;
    }

}
