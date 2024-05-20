package com.implbd.crudStudentsJPA.service;

import com.implbd.crudStudentsJPA.dto.StudentRequestDTO;
import com.implbd.crudStudentsJPA.dto.StudentResponseDTO;

import java.util.List;

public interface IStudentService {

    List<StudentResponseDTO> getStudents();

    void saveStudent(StudentRequestDTO student);

    void deleteStudent(Long id);

    StudentResponseDTO findStudentById(Long id);

    StudentResponseDTO updateStudent(Long id, String newName, String newLastname);
}
