package com.example._6_persona_practicatestyvalidaciones.service;

import com.example._6_persona_practicatestyvalidaciones.dto.requestDTO.DeporteRequestDTO;
import com.example._6_persona_practicatestyvalidaciones.dto.responseDTO.DeporteResponseDTO;

public interface IDeporteService {
    DeporteResponseDTO agregarDeporte(DeporteRequestDTO deporteRequestDTO);
}
