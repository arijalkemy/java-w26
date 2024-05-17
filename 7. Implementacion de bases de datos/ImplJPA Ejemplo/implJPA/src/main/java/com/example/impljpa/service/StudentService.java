package com.example.impljpa.service;

import com.example.impljpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository _studentRepository){
        studentRepository = _studentRepository;
    }

}
