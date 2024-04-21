package com.example.demo.service;

import com.example.demo.dto.PlatoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public interface IPlatoService {
    PlatoResponseDTO obtenerDetallesPlato(String nombrePlato, double pesoGramos);
}
