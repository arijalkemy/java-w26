package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.service;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.dto.InformacionPlatoResponseDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.dto.IngredienteDto;

import java.util.List;

public interface IPlatoService {
    public InformacionPlatoResponseDto searchInformacion(String nombre, Integer peso);
}
