package org.example.crud_jpa.service;

import org.example.crud_jpa.dto.StudentRequestDTO;
import org.example.crud_jpa.dto.StudentResponseDTO;
import org.example.crud_jpa.exceptions.NotFoundException;

import java.util.*;

public interface IStudentService {
    List<StudentResponseDTO> getStudents();
    StudentResponseDTO saveStudent(StudentRequestDTO student);
    void deleteStudent(Long id);
    StudentResponseDTO findStudent(Long id) throws NotFoundException;
    StudentResponseDTO findStudent(String name) throws NotFoundException;
    StudentResponseDTO updateStudent(Long id, String newName, String newLastName) throws NotFoundException;
}
