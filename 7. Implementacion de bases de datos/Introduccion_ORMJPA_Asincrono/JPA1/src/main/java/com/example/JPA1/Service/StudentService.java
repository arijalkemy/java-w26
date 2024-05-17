package com.example.JPA1.Service;

import com.example.JPA1.Repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final IStudentRepository iStudentRepository;

    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }
}
