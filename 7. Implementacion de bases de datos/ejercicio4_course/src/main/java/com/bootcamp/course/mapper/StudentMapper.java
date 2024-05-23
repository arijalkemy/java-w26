package com.bootcamp.course.mapper;

import com.bootcamp.course.dto.StudentDTO;
import com.bootcamp.course.entity.Student;
import org.modelmapper.ModelMapper;

import java.util.List;

public class StudentMapper {

    public static StudentDTO studentToStudentDTO(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(student, StudentDTO.class);
    }

    public static Student studentDTOToStudent(StudentDTO studentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(studentDTO, Student.class);
    }

    public static List<StudentDTO> studentListToStudentDTOList(List<Student> studentList) {
        return studentList.stream()
                .map(StudentMapper::studentToStudentDTO)
                .toList();
    }

}
