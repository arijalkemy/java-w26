package com.meli.implementacionjpa.service;

import com.meli.implementacionjpa.repository.IStudentRespository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final IStudentRespository studentRespository;

    public StudentService(IStudentRespository studentRespository) {
        this.studentRespository = studentRespository;
    }
}
