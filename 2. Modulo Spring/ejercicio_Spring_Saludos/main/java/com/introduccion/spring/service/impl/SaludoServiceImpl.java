package com.introduccion.spring.service.impl;

import com.introduccion.spring.service.ISaludoService;
import org.springframework.stereotype.Service;

@Service
public class SaludoServiceImpl implements ISaludoService {
    @Override
    public String saludar(String name) {
        return "Hola " + name;
    }
}
