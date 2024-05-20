package com.implbd.crudStudentsJPA.utils.mappers;

import com.implbd.crudStudentsJPA.dto.StudentRequestDTO;
import com.implbd.crudStudentsJPA.dto.StudentResponseDTO;
import com.implbd.crudStudentsJPA.entity.Student;

public class StudentMappers {

    private StudentMappers(){}

    public static StudentResponseDTO studentToStudentResponseDTO(Student student){
        return new StudentResponseDTO(
                student.getId(),
                student.getDni(),
                student.getName(),
                student.getLastName()
        );
    }

    public static Student studentRequestDTOToStudent(StudentRequestDTO studentDTO){
        Student student = new Student();
        student.setDni(studentDTO.getDni());
        student.setName(studentDTO.getName());
        student.setLastName(studentDTO.getLastName());
        return student;
    }

}
