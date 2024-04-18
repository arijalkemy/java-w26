package com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.service;

import com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.dto.PlatoDTO;

import java.util.List;

public interface IContadorCaloriasService {
    public List<PlatoDTO> getCaloriasPlato(List<PlatoDTO> platos);
}
