package com.example.EjercicioDeporte.service;

import com.example.EjercicioDeporte.dto.DeporteDTO;

import java.util.List;

public interface IDeporteService {
    List<DeporteDTO> buscarTodosDeportes();
    String buscarPorNombre(String name);
}
