package com.miprimerproyecto.pruebaspring.service;

import com.miprimerproyecto.pruebaspring.ISaludoService;
import org.springframework.stereotype.Service;

@Service
public class SaludoService implements ISaludoService {
    @Override
    public String saludar(String name) {
        return "Hola " + name + "!";
    }
}
