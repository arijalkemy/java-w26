package com.miprimirproyecto.pruebaspring.services.service.impl;

import com.miprimirproyecto.pruebaspring.services.ISaludosService;
import org.springframework.stereotype.Service;

@Service
public class SaludoServiceImpl implements ISaludosService {
    @Override
    public String saludar(String name) {
        return "Hola a todos " + name;
    }
}
