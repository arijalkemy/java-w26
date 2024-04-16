package com.example.demo.service.service.impl;

import com.example.demo.service.SaludoService;
import org.springframework.stereotype.Service;

@Service
public class SaludoServiceImpl implements SaludoService {
    @Override
    public String saludar(String name) {
        return "Hola " + name;
    }
}
