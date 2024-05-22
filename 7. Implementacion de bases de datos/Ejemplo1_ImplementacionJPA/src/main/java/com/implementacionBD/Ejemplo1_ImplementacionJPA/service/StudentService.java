package com.implementacionBD.Ejemplo1_ImplementacionJPA.service;

import com.implementacionBD.Ejemplo1_ImplementacionJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



}
