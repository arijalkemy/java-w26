package com.example._00_practica_inicial.utils;

import com.example._00_practica_inicial.dto.request.StudentRequestDTO;
import com.example._00_practica_inicial.dto.response.StudentResponseDTO;
import com.example._00_practica_inicial.model.Student;
import org.modelmapper.ModelMapper;

public class StudentMapper {
    private static final ModelMapper mapper = new ModelMapper();

    public static StudentResponseDTO transferToResponseDto(Student student){
        return mapper.map(student, StudentResponseDTO.class);
    }

    public static Student mapToEntityFromRequest(StudentRequestDTO studentRequestDTO){
        return mapper.map(studentRequestDTO, Student.class);
    }

    public static Student mapToEntityFromResponse(StudentResponseDTO studentResponseDTO){
        return mapper.map(studentResponseDTO, Student.class);
    }
}
