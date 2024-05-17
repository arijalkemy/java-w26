package com.example.JPA.Service;

import com.example.JPA.Repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final IStudentRepository iStudentRepository;

    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }
}
