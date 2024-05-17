package com.example._00_practica_inicial.service;

import com.example._00_practica_inicial.dto.StudentRequestDTO;
import com.example._00_practica_inicial.dto.StudentResponseDTO;

public interface IStudentService {
    StudentResponseDTO add(StudentRequestDTO studentRequest);
}
