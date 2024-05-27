package com.example.implementJPA.service;

import com.example.implementJPA.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StrudentService {
    private final IStudentRepository stuRepo;

    public  StrudentService(IStudentRepository stuRepo){
        this.stuRepo = stuRepo;
    }
}
