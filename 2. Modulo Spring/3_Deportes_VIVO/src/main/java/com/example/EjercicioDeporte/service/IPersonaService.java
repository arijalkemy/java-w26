package com.example.EjercicioDeporte.service;

import com.example.EjercicioDeporte.dto.PersonaDTO;

import java.util.List;

public interface IPersonaService {
    List<PersonaDTO> buscarPersonasDeportistas();
}
