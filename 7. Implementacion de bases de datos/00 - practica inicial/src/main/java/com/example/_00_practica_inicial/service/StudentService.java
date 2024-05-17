package com.example._00_practica_inicial.service;

import com.example._00_practica_inicial.dto.StudentRequestDTO;
import com.example._00_practica_inicial.dto.StudentResponseDTO;
import com.example._00_practica_inicial.model.Student;
import com.example._00_practica_inicial.repository.IStudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepository iStudentRepository;

    ObjectMapper mapper = new ObjectMapper();

    public StudentResponseDTO add(StudentRequestDTO studentRequest){

        Student student = mapper.convertValue(studentRequest, Student.class);

        return mapper.convertValue(iStudentRepository.save(student), StudentResponseDTO.class);
    }

}
