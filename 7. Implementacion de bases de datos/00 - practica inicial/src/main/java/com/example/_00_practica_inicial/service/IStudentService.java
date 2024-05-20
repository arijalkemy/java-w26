package com.example._00_practica_inicial.service;

import com.example._00_practica_inicial.dto.request.StudentRequestDTO;
import com.example._00_practica_inicial.dto.response.StudentResponseDTO;

import java.util.List;

public interface IStudentService {
    StudentResponseDTO add(StudentRequestDTO studentRequest);
    StudentResponseDTO edit(int id, String name) throws Exception;
    List<StudentResponseDTO> getStudents();
    StudentResponseDTO getStudent(int id) throws Exception;
    public void deleteStudent(int id) throws Exception;

}
