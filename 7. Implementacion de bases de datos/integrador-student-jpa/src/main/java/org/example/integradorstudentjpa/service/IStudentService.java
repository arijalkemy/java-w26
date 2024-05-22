package org.example.integradorstudentjpa.service;


import org.example.integradorstudentjpa.dto.StudentRequestDTO;
import org.example.integradorstudentjpa.dto.StudentResponseDTO;
import org.example.integradorstudentjpa.dto.StudentUpdateDTO;

import java.util.List;

public interface IStudentService {
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO findStudentById(Long id);
    void saveStudent(StudentRequestDTO studentRequestDTO);
    void updateStudent(StudentUpdateDTO studentupdateDTO);
    void deleteStudent(Long id);
}
