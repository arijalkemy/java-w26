package com.bootcamp.course.service;

import com.bootcamp.course.dto.StudentDTO;

import java.util.List;

public interface IStudentService {

    StudentDTO save(StudentDTO studentDTO);

    List<StudentDTO> findAll();

    StudentDTO findById(Long id);

    void delete(Long id);

    StudentDTO update(Long id, String identification, String name, String lastName);

    StudentDTO update(StudentDTO studentDTO);

    StudentDTO findAverageStudent(Long studentId);

}
