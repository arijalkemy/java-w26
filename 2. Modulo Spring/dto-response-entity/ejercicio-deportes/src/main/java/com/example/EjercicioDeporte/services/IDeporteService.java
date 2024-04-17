package com.example.EjercicioDeporte.services;

import com.example.EjercicioDeporte.dto.DeporteDTO;
import com.example.EjercicioDeporte.dto.PersonaDTO;

import java.util.List;

public interface IDeporteService {
    List<DeporteDTO> buscarTodosDeportes();
    String buscarPorNombre(String name);
    List<PersonaDTO> buscarPersonasDeportistas();
}
