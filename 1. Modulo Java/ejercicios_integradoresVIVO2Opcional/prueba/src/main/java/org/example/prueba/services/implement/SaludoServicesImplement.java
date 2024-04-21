package org.example.prueba.services.implement;

import org.example.prueba.services.ISaludoService;
import org.springframework.stereotype.Service;

@Service
public class SaludoServicesImplement implements ISaludoService {
    @Override
    public String saludo(String nombre) {
        return "Hola " + nombre;
    }
}
