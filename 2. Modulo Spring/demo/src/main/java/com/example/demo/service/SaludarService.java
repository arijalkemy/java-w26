package com.example.demo.service;

import com.example.demo.service.interfaces.ISaludarService;
import org.springframework.stereotype.Service;

@Service
public class SaludarService implements ISaludarService {
    @Override
    public String saludar(String name) {
        return "Hola " + name;
    }
}
